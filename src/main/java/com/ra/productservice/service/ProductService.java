package com.ra.productservice.service;

import com.ra.productservice.dto.ProductResponseDTO;
import com.ra.productservice.entity.ProductEntity;
import com.ra.productservice.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductResponseDTO getProductById(Long id) {
        ProductEntity product = productRepository.findById(id)
                .orElseGet(() -> ProductEntity.builder()
                        .id(id)
                        .name("Laptop Gaming")
                        .sku("SKU-998877")
                        .importPrice(1200.0)
                        .sellPrice(1500.0)
                        .stockQuantity(50)
                        .build());

        return ProductResponseDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .sellPrice(product.getSellPrice())
                .build();
    }
}
