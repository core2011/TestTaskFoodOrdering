package com.test.task.foodordering.repository;

import com.test.task.foodordering.model.Cuisine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuisineRepo extends JpaRepository<Cuisine, Integer> {
}
