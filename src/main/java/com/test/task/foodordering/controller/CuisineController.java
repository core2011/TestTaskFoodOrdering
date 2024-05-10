package com.test.task.foodordering.controller;

import com.test.task.foodordering.model.Cuisine;
import com.test.task.foodordering.repository.CuisineRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/addCuisine", method = RequestMethod.GET)
@RequiredArgsConstructor
public class CuisineController {

    private final CuisineRepo cuisineRepo;

    @PostMapping
    public Cuisine saveCuisine(@RequestBody Cuisine cuisine){
        return cuisineRepo.save(cuisine);
    }

}
