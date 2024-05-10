package com.test.task.foodordering.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
@Table(name = "my_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "main_id")
    private Main main;

    @OneToOne
    @JoinColumn(name = "dessert_id")
    private Dessert dessert;

    @OneToOne
    @JoinColumn(name = "drink_id")
    private Drink drink;

    private String ise;
    private String lemon;

}
