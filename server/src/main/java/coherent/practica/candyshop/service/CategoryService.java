package coherent.practica.candyshop.service;

import coherent.practica.candyshop.exception.CandyAlreadyAddedException;
import coherent.practica.candyshop.exception.CandyNotFoundException;
import coherent.practica.candyshop.exception.CategoryAlreadyAddedException;
import coherent.practica.candyshop.exception.CategoryNotFoundException;
import coherent.practica.candyshop.model.Candy;
import coherent.practica.candyshop.model.Category;
import coherent.practica.candyshop.repository.CandyRepository;
import coherent.practica.candyshop.repository.CategoryRepository;
import coherent.practica.candyshop.repository.OrderCandyRepository;
import coherent.practica.candyshop.repository.WishlistCandyRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CandyRepository candyRepository;
    private final OrderCandyRepository orderCandyRepository;
    private final WishlistCandyRepository wishlistCandyRepository;

    public CategoryService(CategoryRepository categoryRepository, CandyRepository candyRepository,
                           OrderCandyRepository orderCandyRepository, WishlistCandyRepository wishlistCandyRepository) {
        this.categoryRepository = categoryRepository;
        this.candyRepository = candyRepository;
        this.orderCandyRepository = orderCandyRepository;
        this.wishlistCandyRepository = wishlistCandyRepository;
    }

    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    public Category getCategoryByName(String categoryName) {
        return categoryRepository.findByName(categoryName).orElseThrow(
                () -> new CategoryNotFoundException(categoryName));
    }

    public Category addCategory(Category category) {
        categoryRepository.findByName(category.getName()).ifPresent(s -> {
            throw new CategoryAlreadyAddedException(category.getName());
        });

        return categoryRepository.save(category);
    }

    public ResponseEntity<String> deleteCategory(String categoryName) {
        Category category = categoryRepository.findByName(categoryName).orElseThrow(
                () -> new CategoryNotFoundException(categoryName));

        //It works but it could be improved
        List<Candy> candies = candyRepository.getAllByCategory(category);
        for(Candy candy : candies) {
            orderCandyRepository.deleteByCandy(candy);
            wishlistCandyRepository.deleteByCandy(candy);
            candyRepository.delete(candy);
        }
        categoryRepository.delete(category);

        return ResponseEntity.ok()
                .body("Category with name: " + categoryName + " deleted successfully.");
    }
}
