package com.test.task.foodordering.controller;

import com.test.task.foodordering.model.Cuisine;
import com.test.task.foodordering.repository.CuisineRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/cuisine")
@RequiredArgsConstructor
public class CuisineController {

    private final CuisineRepo cuisineRepo;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cuisine addNew(@RequestParam(name = "name") String cuisineName) {
        return cuisineRepo.save(new Cuisine(cuisineName));
    }

}
