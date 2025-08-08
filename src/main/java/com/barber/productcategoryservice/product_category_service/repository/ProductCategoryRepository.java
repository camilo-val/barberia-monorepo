package com.barber.productcategoryservice.product_category_service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.barber.productcategoryservice.product_category_service.model.ProductCategoryEntity;

public interface ProductCategoryRepository extends MongoRepository<ProductCategoryEntity, Long>{

}
