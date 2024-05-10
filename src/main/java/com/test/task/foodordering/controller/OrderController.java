package com.test.task.foodordering.controller;

import com.test.task.foodordering.model.Order;
import com.test.task.foodordering.repository.OrderRepo;
import com.test.task.foodordering.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/order", method = RequestMethod.GET)
@RequiredArgsConstructor
public class OrderController {

    private final OrderRepo orderRepo;
    private final OrderService orderService;

    private boolean drinkPresent;
    private boolean icePresent;
    private boolean lemonPresent;

    @PostMapping
    public String createOrder(
            @RequestParam(name = "main") String mainId,
            @RequestParam(name = "dessert") String dessertId,
            @RequestParam(name = "drink", required = false, defaultValue = "0") String drinkId,
            @RequestParam(name = "ice", required = false, defaultValue = "0") String ice,
            @RequestParam(name = "lemon", required = false, defaultValue = "0") String lemon
    ) {
        Order order = new Order();
        drinkPresent = !drinkId.equals("0");
        icePresent = !ice.equals("0");
        lemonPresent = !lemon.equals("0");
        order.setMain(orderService.getMainById(mainId));
        order.setDessert(orderService.getDessertById(dessertId));
        order.setDrink(orderService.getDrinkById(drinkId));
        order.setIse(ice);
        order.setLemon(lemon);
        int i = 0;
        orderRepo.save(order);
        return orderToString(order);
    }

    private String orderToString(Order order) {
        return "Order number - " + order.getId()
                + "\nName main dish - " + order.getMain().getName()
                + ", Cuisine from - " + order.getMain().getCuisine().getName()
                + ", price - " + order.getMain().getPrice()
                + "\nName dessert dish - " + order.getDessert().getName()
                + ", Cuisine from - " + order.getDessert().getCuisine().getName()
                + ", price - " + order.getDessert().getPrice()
                + "\n" + (drinkPresent ? "name drink - " + order.getDrink().getName()
                + ", Cuisine from - " + order.getDrink().getCuisine().getName()
                + ", price - " + order.getDrink().getPrice() : "No drink ordered")
                + "\n" + (icePresent ? "We've added piece of ice" : "No ice ordered")
                + "\n" + (lemonPresent ? "We've added piece of lemon" : "No lemon ordered")
                + "\nTotal price - " + calculateSumOrder(order);
    }

    private int calculateSumOrder(Order order) {
        return order.getMain().getPrice()
                + order.getDessert().getPrice()
                + (drinkPresent ? order.getDrink().getPrice() : 0);
    }

}
