package com.luv2code.ecommerce.controller;

import com.luv2code.ecommerce.entity.Product;
import com.luv2code.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;


    @GetMapping("/products")
    public List<Product> getProducts() {
        return productService.getAllProducts();
    }


    @GetMapping("/products/{id}")
    public Optional<Product> getProduct(@PathVariable Long id) {
        return productService.getProductById(id);
    }


    @GetMapping("/category/{id}")
    public List<Product> getProductsByCategory(@PathVariable Long id) {
        return productService.findByCategoryId(id);
    }


    @GetMapping("/products/search/{name}")
    public List<Product> searchProducts(@PathVariable String name) {
        return productService.findByNameContaining(name);
    }



    @GetMapping("{categoryId}/productsPaging")
    public ResponseEntity<Page<Product>> getProductsByCategoryId(
            @PathVariable Long categoryId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Page<Product> products = productService.getProductsByCategoryId(categoryId, page, size);
        if (products.getContent().isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(products);
    }



    @GetMapping("/{name}/paging")
    public ResponseEntity<Page<Product>> getProductsByName(
            @PathVariable String name,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Page<Product> products = productService.getProductsByName(name, page, size);
        if (products.getContent().isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(products);
    }








}
