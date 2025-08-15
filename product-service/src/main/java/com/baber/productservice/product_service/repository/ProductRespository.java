package com.baber.productservice.product_service.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.baber.productservice.product_service.model.ProductModel;

public interface ProductRespository extends MongoRepository<ProductModel,Long>{
    List<ProductModel> findByCategoryId(Long id);
}
