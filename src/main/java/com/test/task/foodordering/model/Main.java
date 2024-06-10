package com.test.task.foodordering.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "main")
public class Main extends Product {

    public Main() {
        super();
    }

    public Main(String name, int price, Cuisine cuisine) {
        super(name, price, cuisine);
    }
}
