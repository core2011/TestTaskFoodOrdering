package com.test.task.foodordering;

import com.test.task.foodordering.model.Cuisine;
import com.test.task.foodordering.model.Main;
import com.test.task.foodordering.model.Cart;
import com.test.task.foodordering.repository.CuisineRepo;
import com.test.task.foodordering.repository.MainRepo;
import com.test.task.foodordering.repository.OrderRepo;
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

        Cuisine cuisinePolish = new Cuisine("Polish");
        Cuisine cuisineMexican = new Cuisine("Mexican");
        Cuisine cuisineItalian = new Cuisine("Italian");

        cuisineRepo.save(cuisinePolish);
        cuisineRepo.save(cuisineMexican);
        cuisineRepo.save(cuisineItalian);

        Cart cart = new Cart("1", "1");

        Main mainPolish1 = new Main("mainPolish1", 50, cuisinePolish, cart);
        Main mainPolish2 = new Main("mainPolish2", 60, cuisinePolish, cart);
        Main mainPolish3 = new Main("mainPolish3", 70, cuisinePolish, cart);

        Main mainMexican1 = new Main("mainMexican1", 51, cuisineMexican, cart);
        Main mainMexican2 = new Main("mainMexican2", 61, cuisineMexican, cart);
        Main mainMexican3 = new Main("mainMexican3", 71, cuisineMexican, cart);

        List<Main> mainList = Arrays.asList(
                mainPolish1,
                mainPolish2, mainPolish3,
                mainMexican1
                , mainMexican2, mainMexican3
        );

        for (Main m : mainList){
            mainRepo.save(m);
        }
        cart.setMains(mainList);


        orderRepo.save(cart);


    }
}
