package com.barber.productcategoryservice.product_category_service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.barber.productcategoryservice.product_category_service.model.ProductCategoryEntity;
import com.barber.productcategoryservice.product_category_service.repository.ProductCategoryRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService{

    private final ProductCategoryRepository categoryRepository;

    @Override
    public Optional<ProductCategoryEntity> findById(Long id) {
        return this.categoryRepository.findById(id);
    }

    @Override
    public List<ProductCategoryEntity> findAll() {
        return this.categoryRepository.findAll();
    }

    @Override
    public Optional<ProductCategoryEntity> save(ProductCategoryEntity category) {
       return Optional.of(this.categoryRepository.save(category));
    }

}
