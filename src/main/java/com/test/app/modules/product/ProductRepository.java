package com.test.app.modules.product;

import org.springframework.data.jpa.repository.JpaRepository;
import com.test.app.modules.product.entity.Product;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
}