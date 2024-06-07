package com.test.task.foodordering.repository;

import com.test.task.foodordering.model.Main;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
//public interface MainRepo extends ProductRepo {
public interface MainRepo extends JpaRepository<Main, Long> {
}
