package com.test.task.foodordering.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class Product {

    public Product() {
    }

    public Product(String name, int price, Cuisine cuisine) {
        this.name = name;
        this.price = price;
        this.cuisine = cuisine;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int price;

    @ManyToOne
    @JoinColumn(name = "cuisine_id")
    private Cuisine cuisine;

//    @ManyToOne
//    @JoinColumn(name = "order_id")
//    private Order order;

}
