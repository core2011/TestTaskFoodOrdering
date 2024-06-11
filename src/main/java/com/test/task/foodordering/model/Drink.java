package com.test.task.foodordering.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.util.Objects;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "drink")
public class Drink extends Product {
    public Drink(String name, int price, Cuisine cuisine) {
        super(name, price, cuisine);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Drink drink = (Drink) o;
        return getId() != null && Objects.equals(getId(), drink.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
