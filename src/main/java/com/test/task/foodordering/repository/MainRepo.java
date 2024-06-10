package com.test.task.foodordering.repository;

import com.test.task.foodordering.model.Main;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MainRepo extends JpaRepository<Main, Long> {
}
