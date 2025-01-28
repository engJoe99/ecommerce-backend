package com.luv2code.ecommerce.service;


import com.luv2code.ecommerce.dto.Purchase;
import com.luv2code.ecommerce.dto.PurchaseResponse;

public interface CheckoutService {

    // Process the purchase order and return a response containing the order tracking number
    PurchaseResponse placeOrder(Purchase purchase);

}
