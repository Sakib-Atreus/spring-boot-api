package com.test.app.modules.order;

import org.springframework.data.jpa.repository.JpaRepository;
import com.test.app.modules.order.entity.Order;

import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, UUID> {
}