package com.test.task.foodordering.controller;

import com.test.task.foodordering.model.Drink;
import com.test.task.foodordering.service.DrinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/addDrink/{cuisineId}", method = RequestMethod.GET)
@RequiredArgsConstructor
public class DrinkController {

    private final DrinkService drinkService;

    @PostMapping
    public ResponseEntity saveMDrink(
            @PathVariable("cuisineId") int cuisineId,
            @RequestBody Drink drink) {
        if (drinkService.addDrink(cuisineId, drink)) {
            return new ResponseEntity(HttpStatus.CREATED);
        } else return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

}
