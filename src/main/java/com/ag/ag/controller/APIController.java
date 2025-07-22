package com.ag.ag.controller;

import com.ag.ag.dto.OrderResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class APIController {

    @PostMapping("/paymentServiceFallBack")
    public String paymentServiceFallBack() {
        return "Payment Service is taking longer than expected. Please try again later.";
    }
    @PostMapping("/orderServiceFallBack")
    public OrderResponse orderServiceFallBack() {
        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setOrderId("1");
        orderResponse.setProductId("Mobile");
        orderResponse.setQuantity(1);
        orderResponse.setStatus("Pending");
        orderResponse.setPrice(50000.0);
        orderResponse.setProductName("Samsung Galaxy S21");
        return orderResponse;
    }
}
