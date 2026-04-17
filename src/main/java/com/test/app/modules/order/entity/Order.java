package com.test.app.modules.order.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

import com.test.app.modules.order.enums.OrderStatus;
import com.test.app.modules.product.entity.Product;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    private Integer quantity;

    private Double totalPrice;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;
}