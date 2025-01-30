package com.luv2code.ecommerce.controller;


import com.luv2code.ecommerce.dto.OrderDTO;
import com.luv2code.ecommerce.entity.Order;
import com.luv2code.ecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api-orders")
public class OrderController {

    @Autowired
    private OrderService orderService;


   /* @GetMapping("/{email}/paging")
    public ResponseEntity<Page<Order>> getOrdersForCustomer(
            @PathVariable String email,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Page<Order> orders = orderService.getOrdersForCustomer(email, page, size);
        return ResponseEntity.ok(orders);

    }*/

    @GetMapping("/{email}/paging")
    public ResponseEntity<Page<OrderDTO>> getOrdersByCustomerEmail(
            @PathVariable String email,
            @RequestParam (defaultValue = "0") int page,
            @RequestParam (defaultValue = "10") int size) {
        Page<OrderDTO> orderDTOPage = orderService.findOrdersByCustomerEmail(email, page, size);
        return ResponseEntity.ok(orderDTOPage);
    }



}
