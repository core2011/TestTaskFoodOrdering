package com.test.task.foodordering.repository;

import com.test.task.foodordering.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<Cart, Long> {
}
