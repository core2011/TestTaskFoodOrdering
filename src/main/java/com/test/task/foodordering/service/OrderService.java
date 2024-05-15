package com.test.task.foodordering.service;

import com.test.task.foodordering.model.Dessert;
import com.test.task.foodordering.model.Drink;
import com.test.task.foodordering.model.Main;
import com.test.task.foodordering.repository.DessertRepo;
import com.test.task.foodordering.repository.DrinkRepo;
import com.test.task.foodordering.repository.MainRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final MainRepo mainRepo;
    private final DessertRepo dessertRepo;
    private final DrinkRepo drinkRepo;

    public Main getMainById(String id){
        var mainOptional = mainRepo.findById(Integer.parseInt(id));
        return mainOptional.orElse(null);
    }

    public Dessert getDessertById(String id){
        var dessertOptional = dessertRepo.findById(Integer.parseInt(id));
        return dessertOptional.orElse(null);
    }

    public Drink getDrinkById(String id){
        var drinkOptional = drinkRepo.findById(Integer.parseInt(id));
        return drinkOptional.orElse(null);
    }
}
