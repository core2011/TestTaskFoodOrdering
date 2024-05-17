package com.test.task.foodordering.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.MERGE, orphanRemoval = true)
    private List<Main> mains = new ArrayList<>();

//    @OneToOne(cascade = CascadeType.PERSIST)
//    @JoinColumn(name = "dessert_id")
//    private Dessert dessert;
//
//    @OneToOne(cascade = CascadeType.PERSIST)
//    @JoinColumn(name = "drink_id")
//    private Drink drink;


    public Cart(String ise, String lemon) {
        this.ise = ise;
        this.lemon = lemon;
    }

    private String ise;
    private String lemon;

}
