package com.test.app.modules.order;

import com.test.app.common.response.ApiResponse;
import com.test.app.modules.order.dto.*;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.*;

@Tag(name = "Order", description = "Order Management APIs")
@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ApiResponse<OrderResponse> placeOrder(@RequestBody OrderRequest request) {
        return new ApiResponse<>(true, "Order placed successfully", orderService.placeOrder(request));
    }

    @GetMapping
    public ApiResponse<List<OrderResponse>> getAllOrders() {
        return new ApiResponse<>(true, "Fetched orders", orderService.getAllOrders());
    }

    @GetMapping("/{id}")
    public ApiResponse<OrderResponse> getOrderById(@PathVariable UUID id) {
        return new ApiResponse<>(true, "Fetched order", orderService.getOrderById(id));
    }
}