package com.test.app.modules.order.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

import com.test.app.modules.order.enums.OrderStatus;

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

    private UUID productId;

    private Integer quantity;

    private Double totalPrice;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;
}