package com.test.task.foodordering.controller;

import com.test.task.foodordering.model.Dessert;
import com.test.task.foodordering.service.DesertService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/addDessert/{cuisineId}", method = RequestMethod.GET)
@RequiredArgsConstructor
public class DessertController {

    private final DesertService desertService;

    @PostMapping
    public ResponseEntity saveDessert(
            @PathVariable("cuisineId") int cuisineId,
            @RequestBody Dessert dessert) {
        if (desertService.addDessert(cuisineId, dessert)) {
            return new ResponseEntity(HttpStatus.CREATED);
        } else return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

}