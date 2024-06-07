package com.test.task.foodordering.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "main")
public class Main extends Product {

    public Main(){
        super();
    }

    public Main(String name, int price, Cuisine cuisine) {
        super(name, price, cuisine);
    }




//    @OneToMany(mappedBy = "main", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Order> orders = new ArrayList<>();

}
