package com.barber.productcategoryservice.product_category_service.model.dto;

import java.util.Date;
import java.util.Random;

import com.barber.productcategoryservice.product_category_service.model.ProductCategoryEntity;

import lombok.Builder;

@Builder
public record ProductCategoryRequestDto(String name, boolean offer, Date initialAt, Date finalAt) {

    public static ProductCategoryEntity toCategoryEntity (ProductCategoryRequestDto request){
        return new ProductCategoryEntity(new Random().nextLong()
        , request.name
        , request.offer
        , request.initialAt
        , request.finalAt);
    }
}
