package com.test.task.foodordering.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "cuisines")
public class Cuisine {

    public Cuisine(String name) {
        this.name = name;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToMany(mappedBy = "cuisine", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Main> mains = new ArrayList<>();

    @OneToMany(mappedBy = "cuisine", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Dessert> desserts = new ArrayList<>();

}
