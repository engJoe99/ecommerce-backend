package com.luv2code.ecommerce.dao;


import com.luv2code.ecommerce.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {


    // Behind the scenes, Spring will execute a query similar to this
    // ===>>>    'SELECT * FROM product where category_id=?'
    List<Product> findByCategoryId( Long id);

    // Behind the scenes, Spring will execute a query similar to this
    // ===>>>    'SELECT * FROM Product p where p.name LIKE ('%', :name, '%')
    List<Product> findByNameContaining(String name);


    // Query to find products by category ID with pagination support
    @Query("SELECT p FROM Product p WHERE p.category.id = :categoryId")
    Page<Product> findByCategoryId(Long categoryId, Pageable pageable);



    // Query to find products by name with pagination support
    @Query("SELECT p FROM Product p WHERE p.name LIKE %:name%")
    Page<Product> findByNameContaining(@Param("name") String name, Pageable pageable);



}
