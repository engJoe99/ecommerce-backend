package com.luv2code.ecommerce.dao;

import com.luv2code.ecommerce.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    // Retrieves a paginated list of orders for a customer with the given email address
//    Page<Order> findAllByCustomer_Email(String email, Pageable pageable);

     Page<Order> findAllByCustomer_EmailOrderByDateCreatedDesc(String email, Pageable pageable);
}
