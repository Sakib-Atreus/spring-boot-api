package com.test.app.modules.product.dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductResponse {
    private UUID id;
    private String name;
    private String description;
    private double price;
    private int quantity;
}