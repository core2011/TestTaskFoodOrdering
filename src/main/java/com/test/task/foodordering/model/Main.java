package com.test.task.foodordering.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "main")
public class Main extends Product {

    public Main(String name, int price, Cuisine cuisine, Order order) {
        super(name, price, cuisine);
        this.order = order;
    }

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

}
