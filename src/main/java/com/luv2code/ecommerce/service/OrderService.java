package com.luv2code.ecommerce.service;


import com.luv2code.ecommerce.dao.OrderRepository;
import com.luv2code.ecommerce.dto.OrderDTO;
import com.luv2code.ecommerce.entity.Order;
import com.luv2code.ecommerce.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

     // Retrieves paginated orders for a customer based on their email
    public Page<Order> getOrdersForCustomer(String email, int page, int size) {
            return orderRepository.findAllByCustomer_EmailOrderByDateCreatedDesc(email, PageRequest.of(page, size));
    }


    // Finds orders for a customer by their email address
    // Parameters:
    //   email - customer's email address
    //   page - page number for pagination
    //   size - number of orders per page
    // Returns: Page of OrderDTO objects containing order details
    public Page<OrderDTO> findOrdersByCustomerEmail(String email, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Order> orderPage = orderRepository.findAllByCustomer_EmailOrderByDateCreatedDesc(email, pageable);
        return orderPage.map(OrderMapper::mapToOrderDTO);
    }
}
