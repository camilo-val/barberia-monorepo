package com.barber.productcategoryservice.product_category_service.service;

import java.util.List;
import java.util.Optional;

import com.barber.productcategoryservice.product_category_service.model.ProductCategoryEntity;

public interface ProductCategoryService {
    Optional<ProductCategoryEntity> findById(Long id);
    List<ProductCategoryEntity> findAll();
    Optional<ProductCategoryEntity> save(ProductCategoryEntity category);
}
