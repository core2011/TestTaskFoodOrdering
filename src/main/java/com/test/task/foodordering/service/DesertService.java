package com.test.task.foodordering.service;

import com.test.task.foodordering.model.Dessert;
import com.test.task.foodordering.model.Main;
import com.test.task.foodordering.repository.CuisineRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DesertService {

    private final CuisineRepo cuisineRepo;

    @Transactional
    public boolean addDessert(int cuisineId, Dessert dessert){
        var cuisine = cuisineRepo.findById(cuisineId).orElseThrow();
        cuisine.addDessert(dessert);
        return true;
    }
}