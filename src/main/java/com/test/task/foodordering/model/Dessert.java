package com.test.task.foodordering.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "dessert")
public class Dessert extends Product {

    public Dessert() {
        super();
    }

    public Dessert(String name, int price, Cuisine cuisine) {
        super(name, price, cuisine);
    }
}