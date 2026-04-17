package com.test.app.modules.product.mapper;

import com.test.app.modules.product.entity.Product;
import com.test.app.modules.product.dto.ProductRequest;
import com.test.app.modules.product.dto.ProductResponse;

public class ProductMapper {

    // DTO -> Entity
    public static Product toEntity(ProductRequest request) {
        Product product = new Product();
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setQuantity(request.getQuantity());
        return product;
    }

    // Entity -> Response
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