package com.test.task.foodordering.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@MappedSuperclass
@RequiredArgsConstructor
public abstract class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private final String name;
    private final int price;

    @ManyToOne
    @JoinColumn(name = "cuisine_id")
    private final Cuisine cuisine;



}
