package com.test.task.foodordering.repository;

import com.test.task.foodordering.model.Drink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrinkRepo extends JpaRepository<Drink, Long> {
}
