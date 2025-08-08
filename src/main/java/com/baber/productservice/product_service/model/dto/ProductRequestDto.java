package com.baber.productservice.product_service.model.dto;

import java.sql.Date;
import java.util.Random;

import com.baber.productservice.product_service.model.ProductModel;

import lombok.Builder;

@Builder
public record ProductRequestDto(String name,
                Long categoryId,
                double price,
                Date createAt,
                Date expirationAt) {

        public static ProductModel asProductModel(ProductRequestDto request) {
                return new ProductModel(
                                new Random().nextLong(), request.name(), request.categoryId(), request.price(),
                                request.createAt(), request.expirationAt());
        }
}
