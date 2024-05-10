package com.test.task.foodordering.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "drink")
public class Drink{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private int price;

    @ManyToOne
    @JoinColumn(name = "cuisine_id")
    private Cuisine cuisine;

}
