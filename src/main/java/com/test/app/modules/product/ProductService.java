package com.test.app.modules.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.test.app.modules.product.dto.*;
import com.test.app.modules.product.entity.Product;
import com.test.app.modules.product.mapper.ProductMapper;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    // CREATE
    public ProductResponse create(ProductRequest request) {
        Product product = ProductMapper.toEntity(request);
        
        Product saved = productRepository.save(product);

        return ProductMapper.toResponse(saved);
    }

    // GET ALL
    public List<ProductResponse> getAll() {
        return productRepository.findAll()
                .stream()
                .map(ProductMapper::toResponse)
                .toList();
    }

    // GET BY ID
    public ProductResponse getById(UUID id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        return ProductMapper.toResponse(product);
    }

    // UPDATE
    public ProductResponse update(UUID id, ProductRequest request) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setQuantity(request.getQuantity());

        return ProductMapper.toResponse(productRepository.save(product));
    }

    // DELETE
    public void delete(UUID id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        productRepository.delete(product);
    }
}