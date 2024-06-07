package com.test.task.foodordering.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "drink")
public class Drink extends Product {

    public Drink() {
        super();
    }

    public Drink(String name, int price, Cuisine cuisine) {
        super(name, price, cuisine);
    }
}
