package com.test.task.foodordering.controller;

import com.test.task.foodordering.model.Product;
import com.test.task.foodordering.repository.CuisineRepo;
import com.test.task.foodordering.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final CuisineRepo cuisineRepo;

    @PostMapping("/{cuisineId}")
    @ResponseStatus(HttpStatus.CREATED)
    public Product createNewProduct(
            @RequestBody Product product,
            @PathVariable("cuisineId") Long cuisineId
    ) {
        var cuisine = cuisineRepo.findById(cuisineId).orElseThrow();
        product.setCuisine(cuisine);
        return productService.createProduct(product);
    }

}
