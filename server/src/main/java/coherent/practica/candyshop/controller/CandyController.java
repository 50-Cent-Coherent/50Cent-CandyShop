package coherent.practica.candyshop.controller;


import coherent.practica.candyshop.model.Candy;
import coherent.practica.candyshop.model.Category;
import coherent.practica.candyshop.model.CustomUserDetails;
import coherent.practica.candyshop.service.CandyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;

import java.util.List;

@RequestMapping("/candies")
@RestController
public class CandyController {

    @Autowired
    CandyService candyService;


    @GetMapping()
    @ResponseBody
    public List<Candy> showCandies(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return candyService.getAllCandies();
    }

    @GetMapping("/{candyName}")
    @ResponseBody
    public Candy showCandyByName(@PathVariable String candyName) {
        return candyService.getCandyByName(candyName);
    }

    @PostMapping("/{categoryName}")
    @ResponseBody
    public Candy addCandy(@RequestBody Candy candy,@PathVariable String categoryName) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return candyService.addCandy(candy,categoryName);
    }

    @DeleteMapping("/{candyName}")
    @ResponseBody
    public ResponseEntity<String> deleteCandy(@PathVariable String candyName) {
        return candyService.deleteCandy(candyName);
    }


}
