package com.test.app.modules.order.mapper;

import com.test.app.modules.order.entity.Order;
import com.test.app.modules.order.dto.OrderResponse;

public class OrderMapper {

    public static OrderResponse toResponse(Order order, String productName) {
        return new OrderResponse(
                order.getId(),
                productName,
                order.getQuantity(),
                order.getTotalPrice(),
                order.getStatus().name()
        );
    }
}