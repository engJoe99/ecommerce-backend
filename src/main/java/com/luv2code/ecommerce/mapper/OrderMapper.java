package com.luv2code.ecommerce.mapper;

import com.luv2code.ecommerce.dto.OrderDTO;
import com.luv2code.ecommerce.entity.Order;

public class OrderMapper {

    /**
     * Maps an Order entity to an OrderDTO
     * @param order The Order entity to be mapped
     * @return OrderDTO containing the mapped order data
     */
    public static OrderDTO mapToOrderDTO(Order order) {
        return new OrderDTO(
                order.getId(),                      // Map order ID
                order.getOrderTrackingNumber(),     // Map tracking number
                order.getTotalPrice(),              // Map total price
                order.getTotalQuantity(),           // Map total quantity
                order.getDateCreated()              // Map creation date
        );
    }

}
