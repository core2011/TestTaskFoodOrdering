package com.test.task.foodordering.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "main")
public class Main extends Product {

    public Main(String name, int price, Cuisine cuisine, Cart cart) {
        super(name, price, cuisine);
        this.cart = cart;
    }

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

}
