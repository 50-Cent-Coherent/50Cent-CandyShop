package coherent.practica.candyshop.controller;


import coherent.practica.candyshop.model.Candy;
import coherent.practica.candyshop.service.CandyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/candies")
@RestController
public class CandyController {

    @Autowired
    CandyService candyService;


    @GetMapping()
    @ResponseBody
    public List<Candy> showCandies(){
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
        return candyService.addCandy(candy,categoryName);
    }

    @DeleteMapping("/{candyName}")
    @ResponseBody
    public ResponseEntity<String> deleteCandy(@PathVariable String candyName) {
        return candyService.deleteCandy(candyName);
    }


}
