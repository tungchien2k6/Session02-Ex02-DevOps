package com.ra.productservice.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String sku;

    @Column(nullable = false)
    private Double importPrice; // Giá nhập - Nhạy cảm

    @Column(nullable = false)
    private Double sellPrice;   // Giá bán - Công khai

    @Column(nullable = false)
    private Integer stockQuantity;
}
