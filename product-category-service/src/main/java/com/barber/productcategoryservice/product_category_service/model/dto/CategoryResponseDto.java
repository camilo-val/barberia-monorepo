package com.barber.productcategoryservice.product_category_service.model.dto;

import java.util.Date;

import com.barber.productcategoryservice.product_category_service.model.ProductCategoryEntity;

import lombok.Builder;

@Builder
public record CategoryResponseDto(Long id, String name, boolean offer, Date initialAt, Date finalAt) {

    public static CategoryResponseDto toCategoryResponseDto(ProductCategoryEntity product){
        return builder()
        .id(product.getId())
        .name(product.getName())
        .offer(product.isOffer())
        .initialAt(product.getInitAt())
        .finalAt(product.getFinalAt())
        .build();
    }
}
