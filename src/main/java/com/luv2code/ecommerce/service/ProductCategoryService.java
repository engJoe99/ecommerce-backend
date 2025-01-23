package com.luv2code.ecommerce.service;


import com.luv2code.ecommerce.dao.ProductCategoryRepository;
import com.luv2code.ecommerce.entity.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductCategoryService {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;


    public List<ProductCategory> getAllProductCategories() {
        return productCategoryRepository.findAll();
    }

    public Optional<ProductCategory> getProductCategoryById(Long id) {
        return productCategoryRepository.findById(id);
    }





}
