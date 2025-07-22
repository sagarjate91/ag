package com.ag.ag.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {
    private String orderId;
    private String productId;
    private String productName;
    private int quantity;
    private double price;
    private String status;
    private String paymentId;
    private String paymentStatus;
}
