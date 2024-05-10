package com.test.task.foodordering.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "main")
public class Main{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private int price;

    @ManyToOne
    @JoinColumn(name = "cuisine_id")
    private Cuisine cuisine;

}
