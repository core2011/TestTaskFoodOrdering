package com.test.task.foodordering.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "cuisines")
public class Cuisine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToMany(mappedBy = "cuisine", cascade = CascadeType.ALL)
    private List<Main> mains = new ArrayList<>();

    @OneToMany(mappedBy = "cuisine", cascade = CascadeType.ALL)
    private List<Dessert> desserts = new ArrayList<>();

    @OneToMany(mappedBy = "cuisine", cascade = CascadeType.ALL)
    private List<Drink> drinks = new ArrayList<>();

    public void addDessert(Dessert dessert) {
        dessert.setCuisine(this);
        desserts.add(dessert);
    }

    public void addMain(Main main) {
        main.setCuisine(this);
        mains.add(main);
    }

    public void addDrink(Drink drink) {
        drink.setCuisine(this);
        drinks.add(drink);
    }

}
