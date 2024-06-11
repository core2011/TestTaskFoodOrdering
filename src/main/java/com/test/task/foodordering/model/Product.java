package com.test.task.foodordering.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Main.class, name = "main"),
        @JsonSubTypes.Type(value = Dessert.class, name = "dessert"),
        @JsonSubTypes.Type(value = Drink.class, name = "drink")
})
public abstract class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int price;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "cuisine_id")
    private Cuisine cuisine;

    public Product(String name, int price, Cuisine cuisine) {
        this.name = name;
        this.price = price;
        this.cuisine = cuisine;
    }

    public Product() {
    }
}
