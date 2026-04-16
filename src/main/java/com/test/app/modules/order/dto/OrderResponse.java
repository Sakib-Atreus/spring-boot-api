package com.test.app.modules.order.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {

    private UUID orderId;
    private String productName;
    private Integer quantity;
    private Double totalPrice;
    private String status;
}