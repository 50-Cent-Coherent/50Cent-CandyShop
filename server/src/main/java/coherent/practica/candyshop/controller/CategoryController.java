package coherent.practica.candyshop.controller;


import coherent.practica.candyshop.model.Category;
import coherent.practica.candyshop.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/categories")
@RestController
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping()
    @ResponseBody
    public List<Category> showCategories(){
        return categoryService.getAllCategories();
    }

    @GetMapping("/{categoryName}")
    @ResponseBody
    public Category showCategoryByName(@PathVariable String categoryName) {
        return categoryService.getCategoryByName(categoryName);
    }

    @PostMapping()
    @ResponseBody
    public Category addCategory(@RequestBody Category category) {
        return categoryService.addCategory(category);
    }

    @DeleteMapping("/{categoryName}")
    @ResponseBody
    public ResponseEntity<String> deleteCategory(@PathVariable String categoryName) {
        return categoryService.deleteCategory(categoryName);
    }
}
