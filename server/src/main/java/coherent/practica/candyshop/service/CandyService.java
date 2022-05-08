package coherent.practica.candyshop.service;


import coherent.practica.candyshop.exception.CandyAlreadyAddedException;
import coherent.practica.candyshop.exception.CandyNotFoundException;
import coherent.practica.candyshop.exception.CategoryNotFoundException;
import coherent.practica.candyshop.model.Candy;
import coherent.practica.candyshop.model.Category;
import coherent.practica.candyshop.repository.CandyRepository;
import coherent.practica.candyshop.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandyService {

    @Autowired
    CandyRepository candyRepository;
    @Autowired
    CategoryRepository categoryRepository;

    public List<Candy> getAllCandies(){
        return candyRepository.findAll();
    }

    public Candy getCandyByName(String candyName) {
        return candyRepository.findByName(candyName).orElseThrow(
                () -> new CandyNotFoundException(candyName));
    }

    public Candy addCandy(Candy candy,String categoryName) {
        candyRepository.findByName(candy.getName()).ifPresent(s -> {
            throw new CandyAlreadyAddedException(candy.getName());
        });
        //System.out.println(candy.getCategory());
        Category myCategory =categoryRepository.findByName(categoryName).orElseThrow(
                () -> new CategoryNotFoundException(categoryName));

        Candy newCandy = new Candy(myCategory,candy.getName(),candy.getDescription(),candy.getPhotoUrl(),candy.getQuantity(),candy.getPrice());
        return candyRepository.save(newCandy);
    }

    public ResponseEntity<String> deleteCandy(String candyName) {

        Candy candy = candyRepository.findByName(candyName).orElseThrow(
                () -> new CandyNotFoundException(candyName));

        candyRepository.delete(candy);

        return ResponseEntity.ok()
                .body("Candy with name: " + candyName + " deleted successfully.");
    }


}
