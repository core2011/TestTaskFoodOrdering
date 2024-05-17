package com.test.task.foodordering.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "cuisines")
public class Cuisine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToMany(mappedBy = "cuisine", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Main> mains = new ArrayList<>();

    public Cuisine(String name) {
        this.name = name;
    }
}
