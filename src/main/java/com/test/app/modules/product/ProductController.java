package com.test.app.modules.product;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import com.test.app.common.response.ApiResponse;
import com.test.app.modules.product.dto.*;

import java.util.List;
import java.util.UUID;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Product APIs", description = "CRUD operations for products")
@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ApiResponse<ProductResponse> create(@RequestBody ProductRequest request) {
        return new ApiResponse<>(true, "Created", productService.create(request));
    }

    @GetMapping
    public ApiResponse<List<ProductResponse>> getAll() {
        return new ApiResponse<>(true, "Fetched", productService.getAll());
    }

    @GetMapping("/{id}")
    public ApiResponse<ProductResponse> getById(@PathVariable UUID id) {
        return new ApiResponse<>(true, "Fetched", productService.getById(id));
    }

    @PutMapping("/{id}")
    public ApiResponse<ProductResponse> update(@PathVariable UUID id, @RequestBody ProductRequest request) {
        return new ApiResponse<>(true, "Updated", productService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> delete(@PathVariable UUID id) {
        productService.delete(id);
        return new ApiResponse<>(true, "Deleted", "success");
    }
}