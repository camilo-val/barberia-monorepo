package com.baber.productservice.product_service.model.dto;

import java.util.Date;

import com.baber.productservice.product_service.model.ProductModel;

import lombok.Builder;

@Builder
public record ProductResponseDto(Long id,
        String name,
        Long categoryId,
        double price,
        Date createAt,
        Date expirationAt) {
    public static ProductResponseDto tResponseDto(ProductModel product) {

        return builder()
                .id(product.getId())
                .name(product.getName())
                .categoryId(product.getCategoryId())
                .price(product.getPrice())
                .createAt(product.getCreateAt())
                .expirationAt(product.getExpirationAt())
                .build();
    }
}
