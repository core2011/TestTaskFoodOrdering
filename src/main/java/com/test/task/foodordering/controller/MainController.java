package com.test.task.foodordering.controller;

import com.test.task.foodordering.model.Main;
import com.test.task.foodordering.repository.CuisineRepo;
import com.test.task.foodordering.repository.MainRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/main/{cuisineId}")
@RequiredArgsConstructor
public class MainController {

    private final MainRepo mainRepo;
    private final CuisineRepo cuisineRepo;

    @GetMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Main addNew(
            @RequestParam(name = "name") String mainName,
            @RequestParam(name = "price") int mainPrice,
            @PathVariable(name = "cuisineId") Long cuisineId
    ) {
        Main main = new Main();

        var cuisine = cuisineRepo.findById(cuisineId).orElseThrow();
        main.setName(mainName);
        main.setPrice(mainPrice);
        main.setCuisine(cuisine);

        return mainRepo.save(main);
    }
}
