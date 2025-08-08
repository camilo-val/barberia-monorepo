package com.baber.productservice.product_service.service;

import java.util.List;
import java.util.Optional;

import com.baber.productservice.product_service.model.ProductModel;

public interface ProductService {

    Optional<ProductModel> findById(Long id);
    Optional<ProductModel> save(ProductModel product);
    List<ProductModel> findAll();
    List<ProductModel> findAllByCategoryId(Long categoryId);
}
