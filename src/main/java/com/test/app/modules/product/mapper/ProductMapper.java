package com.test.app.modules.product.mapper;

import com.test.app.modules.product.entity.Product;
import com.test.app.modules.product.dto.ProductResponse;

public class ProductMapper {

    public static ProductResponse toResponse(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getQuantity()
        );
    }
}