package com.luv2code.ecommerce.service;


import com.luv2code.ecommerce.dto.PaymentInfo;
import com.luv2code.ecommerce.dto.Purchase;
import com.luv2code.ecommerce.dto.PurchaseResponse;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;

public interface CheckoutService {

    // Process the purchase order and return a response containing the order tracking number
    PurchaseResponse placeOrder(Purchase purchase);

    // Create a payment intent for processing payment using Stripe API
    PaymentIntent createPaymentIntent(PaymentInfo paymentInfo) throws StripeException;

}
