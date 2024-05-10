package com.test.task.foodordering.service;

import com.test.task.foodordering.model.Main;
import com.test.task.foodordering.repository.CuisineRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MainService {

    private final CuisineRepo cuisineRepo;

    @Transactional
    public boolean addMain(int cuisineId, Main main){
        var cuisine = cuisineRepo.findById(cuisineId).orElseThrow();
        cuisine.addMain(main);
        return true;
    }
}
