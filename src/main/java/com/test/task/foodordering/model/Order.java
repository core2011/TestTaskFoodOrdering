package com.test.task.foodordering.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "orders")
public class Order {

    public Order(String ise, String lemon) {
        this.ise = ise;
        this.lemon = lemon;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ise;
    private String lemon;

    @OneToMany(mappedBy = "order", cascade = CascadeType.MERGE, orphanRemoval = true)
    private List<Main> mains = new ArrayList<>();

}
