package com.luv2code.ecommerce.controller;


import com.luv2code.ecommerce.entity.ProductCategory;
import com.luv2code.ecommerce.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/category")
public class ProductCategoryController {

    @Autowired
    private ProductCategoryService productCategoryService;


    @GetMapping("/all")
    public List<ProductCategory> getAllProductCategories() {
        return productCategoryService.getAllProductCategories();
    }

    @GetMapping("/{id}")
    public Optional<ProductCategory> getProductCategoryById(@PathVariable("id") Long id) {
        return productCategoryService.getProductCategoryById(id);
    }




}
