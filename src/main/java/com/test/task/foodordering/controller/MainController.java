package com.test.task.foodordering.controller;

import com.test.task.foodordering.model.Main;
import com.test.task.foodordering.service.MainService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/addMain/{cuisineId}", method = RequestMethod.GET)
@RequiredArgsConstructor
public class MainController {

    private final MainService mainService;

    @PostMapping
    public ResponseEntity saveMain(
            @PathVariable("cuisineId") int cuisineId,
            @RequestBody Main main) {
        if (mainService.addMain(cuisineId, main)) {
            return new ResponseEntity(HttpStatus.CREATED);
        } else return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
