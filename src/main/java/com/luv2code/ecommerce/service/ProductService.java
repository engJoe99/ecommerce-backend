package com.luv2code.ecommerce.service;

import com.luv2code.ecommerce.dao.ProductRepository;
import com.luv2code.ecommerce.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }


    // Optional<Product> is used here because:
    // 1. It explicitly indicates that the product might not exist for the given ID
    // 2. It helps avoid null pointer exceptions by forcing null checking
    // 3. It provides useful methods like isPresent(), orElse(), etc. to safely handle cases where product is not found
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }


    // This endpoint retrieves all products belonging to a specific category
    // @param id - The ID of the category to filter products by
    // @return List<Product> - A list of products that belong to the specified category
    public List<Product> findByCategoryId(Long id) {
        return productRepository.findByCategoryId(id);
    }


    // This endpoint searches for products based on a given name
    // @param name - The name to search for products
    // @return List<Product> - A list of products that match the given name
    public List<Product> findByNameContaining(String name) {
        return productRepository.findByNameContaining(name);
    }




    // This method retrieves a paginated list of products filtered by category ID
    // @param categoryId - The ID of the category to filter products by
    // @param page - The page number (zero-based) to retrieve
    // @param size - The number of products per page
    // @return Page<Product> - A page object containing the requested products and pagination metadata
    public Page<Product> getProductsByCategoryId(Long categoryId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return productRepository.findByCategoryId(categoryId, pageable);
    }


    // This method retrieves a paginated list of products filtered by name
    // @param name - The name to search for products
    // @param page - The page number (zero-based) to retrieve
    // @param size - The number of products per page
    // @return Page<Product> - A page object containing the requested products and pagination metadata
    public Page<Product> getProductsByName(String name, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return productRepository.findByNameContaining(name, pageable);
    }







}
