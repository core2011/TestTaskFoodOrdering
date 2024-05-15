package com.test.task.foodordering.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "my_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "main_id")
    private Main main;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "dessert_id")
    private Dessert dessert;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "drink_id")
    private Drink drink;

    private String ise;
    private String lemon;

}
