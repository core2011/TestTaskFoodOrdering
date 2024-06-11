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
@Table(name = "main")
@NoArgsConstructor
public class Main extends Product {
    public Main(String name, int price, Cuisine cuisine) {
        super(name, price, cuisine);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Main main = (Main) o;
        return getId() != null && Objects.equals(getId(), main.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
