package com.test.task.foodordering;

import com.test.task.foodordering.model.*;
import com.test.task.foodordering.repository.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class FoodOrdering {
    public static void main(String[] args) {
        var configurationApplicationContext
                = SpringApplication.run(FoodOrdering.class, args);

        var mainRepo = configurationApplicationContext.getBean(MainRepo.class);
        var cuisineRepo = configurationApplicationContext.getBean(CuisineRepo.class);
        var orderRepo = configurationApplicationContext.getBean(OrderRepo.class);
        var desertRepo = configurationApplicationContext.getBean(DessertRepo.class);
        var drinkRepo = configurationApplicationContext.getBean(DrinkRepo.class);

        Cuisine cuisinePolish = new Cuisine("Polish");
        Cuisine cuisineMexican = new Cuisine("Mexican");
        Cuisine cuisineItalian = new Cuisine("Italian");

        cuisineRepo.save(cuisinePolish);
        cuisineRepo.save(cuisineMexican);
        cuisineRepo.save(cuisineItalian);

        Main mainPolish1 = new Main("mainPolish1", 50, cuisinePolish);
        Main mainPolish2 = new Main("mainPolish2", 60, cuisinePolish);
        Main mainPolish3 = new Main("mainPolish3", 70, cuisinePolish);

        Main mainMexican1 = new Main("mainMexican1", 51, cuisineMexican);
        Main mainMexican2 = new Main("mainMexican2", 61, cuisineMexican);
        Main mainMexican3 = new Main("mainMexican3", 71, cuisineMexican);

        List<Main> mainList = Arrays.asList(
                mainPolish1,
                mainPolish2,
                mainPolish3,
                mainMexican1,
                mainMexican2,
                mainMexican3
        );

        for (Main m : mainList) {
            mainRepo.save(m);
        }

        Dessert dessertPolish1 = new Dessert("dessertPolish1", 40, cuisinePolish);

        Dessert dessertMexican1 = new Dessert("dessertMexican1", 41, cuisineMexican);

        List<Dessert> dessertList = Arrays.asList(
                dessertPolish1,
                dessertMexican1
        );

        for (Dessert d : dessertList) {
            desertRepo.save(d);
        }

        Drink drinkPolish1 = new Drink("drinkPolish1", 10, cuisinePolish);

        Drink drinkMexico1 = new Drink("drinkMexico1", 11, cuisineMexican);

        Drink drinkItalian1 = new Drink("drinkItalian1", 12, cuisineItalian);
        Drink drinkItalian2 = new Drink("drinkItalian2", 13, cuisineItalian);

        List<Drink> drinks = Arrays.asList(
                drinkPolish1,
                drinkMexico1,
                drinkItalian1,
                drinkItalian2
        );

        for (Drink d : drinks) {
            drinkRepo.save(d);
        }

        Order order1 = new Order();
        order1.setMain(mainPolish1);
        order1.setDessert(dessertMexican1);
        order1.setIse("0");
        order1.setLemon("0");

        Order order2 = new Order();
        order2.setMain(mainPolish2);
        order2.setDessert(dessertPolish1);
        order2.setIse("1");
        order2.setLemon("1");
        order2.setDrink(drinkItalian1);

        Order order3 = new Order();
        order3.setMain(mainPolish3);
        order3.setDessert(dessertMexican1);
        order3.setIse("1");
        order3.setLemon("0");

        List<Order> orders = Arrays.asList(
                order1,
                order2,
                order3
        );

        for (Order o : orders) {
            orderRepo.save(o);
        }
    }
}
