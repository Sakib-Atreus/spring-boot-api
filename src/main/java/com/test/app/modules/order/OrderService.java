package com.test.app.modules.order;

import com.test.app.modules.order.dto.*;
import com.test.app.modules.order.entity.Order;
import com.test.app.modules.order.enums.OrderStatus;
import com.test.app.modules.order.mapper.OrderMapper;
import com.test.app.modules.product.entity.Product;
import com.test.app.modules.product.ProductRepository;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    @Transactional
    public OrderResponse placeOrder(OrderRequest request) {

        Product product = productRepository.findById(request.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        if (product.getQuantity() < request.getQuantity()) {
            throw new RuntimeException("Product not available");
        }

        // reduce stock
        product.setQuantity(product.getQuantity() - request.getQuantity());

        Order order = new Order();
        order.setProduct(product);
        order.setQuantity(request.getQuantity());
        order.setTotalPrice(product.getPrice() * request.getQuantity());
        order.setStatus(OrderStatus.SUCCESS);

        Order saved = orderRepository.save(order);

        return OrderMapper.toResponse(saved);
    }

    // GET ALL ORDERS
    public List<OrderResponse> getAllOrders() {
        return orderRepository.findAllWithProduct()
                .stream()
                .map(OrderMapper::toResponse)
                .toList();
    }

    // GET ORDER BY ID
    public OrderResponse getOrderById(UUID id) {

        Order order = orderRepository.findByIdWithProduct(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        return OrderMapper.toResponse(order);
    }
}