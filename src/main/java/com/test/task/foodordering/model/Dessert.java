package com.test.task.foodordering.model;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "dessert")
public class Dessert extends Product{

    public Dessert(){
        super();
    }

    public Dessert(String name, int price, Cuisine cuisine) {
        super(name, price, cuisine);
    }


//    @OneToMany(mappedBy = "dessert", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Order> orders = new ArrayList<>();

}