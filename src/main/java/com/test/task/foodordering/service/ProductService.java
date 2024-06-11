package com.test.task.foodordering.service;

import com.test.task.foodordering.model.Dessert;
import com.test.task.foodordering.model.Drink;
import com.test.task.foodordering.model.Main;
import com.test.task.foodordering.model.Product;
import com.test.task.foodordering.repository.DessertRepo;
import com.test.task.foodordering.repository.DrinkRepo;
import com.test.task.foodordering.repository.MainRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final MainRepo mainRepo;
    private final DessertRepo dessertRepo;
    private final DrinkRepo drinkRepo;

    public Product createProduct(Product product) {
        if (product instanceof Main) {
            return mainRepo.save((Main) product);
        } else if (product instanceof Dessert) {
            return dessertRepo.save((Dessert) product);
        } else if (product instanceof Drink) {
            return drinkRepo.save((Drink) product);
        } else {
            throw new IllegalArgumentException("Unsupported product type");
        }
    }

}
