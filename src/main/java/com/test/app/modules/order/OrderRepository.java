package com.test.app.modules.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.test.app.modules.order.entity.Order;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, UUID> {

    @Query("SELECT o FROM Order o JOIN FETCH o.product")
    List<Order> findAllWithProduct();

    @Query("SELECT o FROM Order o JOIN FETCH o.product WHERE o.id = :id")
    Optional<Order> findByIdWithProduct(UUID id);
}