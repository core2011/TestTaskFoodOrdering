package com.test.task.foodordering.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ise;
    private String lemon;

    @ManyToOne
    @JoinColumn(name = "main_id")
    private Main main;

    @ManyToOne
    @JoinColumn(name = "dessert_id")
    private Dessert dessert;

    @ManyToOne
    @JoinColumn(name = "drink_id")
    private Drink drink;

    @Override
    public String toString() {
        return "-------------------------------------------------------------------------" +
                "\nOrder number - " + id
                + "\nName main dish - " + main.getName()
                + ", Cuisine from - " + main.getCuisine().getName()
                + ", price - " + main.getPrice()
                + "\nName dessert dish - " + dessert.getName()
                + ", Cuisine from - " + dessert.getCuisine().getName()
                + ", price - " + dessert.getPrice()
                + "\n" + (drink != null ? "Name drink - " + drink.getName()
                + ", Cuisine from - " + drink.getCuisine().getName()
                + ", price - " + drink.getPrice() : "No drink ordered")
                + "\n" + (ise.equals("1") ? "We've added piece of ice" : "No ice ordered")
                + "\n" + (lemon.equals("1") ? "We've added piece of lemon" : "No lemon ordered")
                + "\nTotal price - " + calculateSumOrder()
                + "\n-------------------------------------------------------------------------";
    }

    private Long calculateSumOrder() {
        return main.getPrice()
                + dessert.getPrice()
                + (drink != null ? drink.getPrice() : 0L);
    }
}
