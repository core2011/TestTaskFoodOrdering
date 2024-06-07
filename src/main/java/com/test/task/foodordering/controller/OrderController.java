package com.test.task.foodordering.controller;

import com.test.task.foodordering.model.Dessert;
import com.test.task.foodordering.model.Main;
import com.test.task.foodordering.model.Order;
import com.test.task.foodordering.repository.DessertRepo;
import com.test.task.foodordering.repository.DrinkRepo;
import com.test.task.foodordering.repository.MainRepo;
import com.test.task.foodordering.repository.OrderRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/order", method = RequestMethod.GET)
@RequiredArgsConstructor
public class OrderController {

    private final OrderRepo orderRepo;
    private final MainRepo mainRepo;
    private final DessertRepo dessertRepo;
    private final DrinkRepo drinkRepo;

    @PostMapping
    public Order createNewOrder(
            @RequestParam(name = "main") Long mainId,
            @RequestParam(name = "dessert") Long dessertId,
            @RequestParam(name = "drink", required = false, defaultValue = "0") Long drinkId,
            @RequestParam(name = "ice", required = false, defaultValue = "0") String ice,
            @RequestParam(name = "lemon", required = false, defaultValue = "0") String lemon
    ) {

        Order order = new Order();

        var mainOptional = mainRepo.findById(mainId);
        var main = mainOptional.orElseThrow();

        var dessertOptional = dessertRepo.findById(dessertId);
        var dessert = dessertOptional.orElseThrow();

        order.setMain(main);
        order.setDessert(dessert);
        order.setLemon(lemon);
        order.setIse(ice);

        var drinkOptional = drinkRepo.findById(drinkId);

        if (drinkOptional.isPresent()){
            var drink= drinkOptional.get();
            order.setDrink(drink);
        }

        orderRepo.save(order);
        System.out.println(order);
        return order;
    }
}
