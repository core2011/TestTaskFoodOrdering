package com.test.task.foodordering.repository;

import com.test.task.foodordering.model.Product;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface ProductRepo extends JpaRepository<Product, Long> {
}
