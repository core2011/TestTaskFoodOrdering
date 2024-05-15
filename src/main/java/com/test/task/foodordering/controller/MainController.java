package com.test.task.foodordering.controller;

import com.test.task.foodordering.model.Main;
import com.test.task.foodordering.service.MainService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/addMain/{cuisineId}", method = RequestMethod.GET)
@RequiredArgsConstructor
public class MainController {

    private final MainService mainService;

    @PostMapping
    public Main saveMain(
            @PathVariable("cuisineId") int cuisineId,
            @RequestBody Main main) {
        return mainService.addMain(cuisineId, main);
    }
}
