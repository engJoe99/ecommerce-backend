package com.luv2code.ecommerce.dto;

import java.math.BigDecimal;
import java.util.Date;

public class OrderDTO {

    private Long id;
    private String orderTrackingNumber;
    private BigDecimal totalPrice;
    private int totalQuantity;
    private Date dateCreated;

    // Default constructor
    public OrderDTO() {}

    // Constructor with all fields
    public OrderDTO(Long id, String orderTrackingNumber, BigDecimal totalPrice,
                    int totalQuantity, Date dateCreated) {
        this.id = id;
        this.orderTrackingNumber = orderTrackingNumber;
        this.totalPrice = totalPrice;
        this.totalQuantity = totalQuantity;
        this.dateCreated = dateCreated;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderTrackingNumber() {
        return orderTrackingNumber;
    }

    public void setOrderTrackingNumber(String orderTrackingNumber) {
        this.orderTrackingNumber = orderTrackingNumber;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

}
