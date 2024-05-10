package com.test.task.foodordering.service;

import com.test.task.foodordering.model.Drink;
import com.test.task.foodordering.repository.CuisineRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DrinkService {

    private final CuisineRepo cuisineRepo;

    @Transactional
    public boolean addDrink(int cuisineId, Drink drink) {
        var cuisine = cuisineRepo.findById(cuisineId).orElseThrow();
        cuisine.addDrink(drink);
        return true;
    }
}