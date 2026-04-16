package com.test.app.modules.order.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class OrderRequest {
    private UUID productId;
    private Integer quantity;
}