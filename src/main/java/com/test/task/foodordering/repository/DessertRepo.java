package com.test.task.foodordering.repository;

import com.test.task.foodordering.model.Dessert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DessertRepo extends JpaRepository<Dessert, Integer> {
}
