package com.baber.productservice.product_service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.baber.productservice.product_service.model.ProductModel;
import com.baber.productservice.product_service.repository.ProductRespository;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@Service
public class ProductServiceImpl implements ProductService{

    private final ProductRespository productRespository;
    private CategoryClientService categoryClientService;

    @Override
    public Optional<ProductModel> findById(Long id) {
        return this.productRespository.findById(id);
    }

    @Override
    public Optional<ProductModel> save(ProductModel product) {
        try {
            Long categoryId = this.categoryClientService.getCategory(product.getCategoryId()).id();
            product.setCategoryId(categoryId);
            return Optional.of(
            this.productRespository.save(product)
        );
        } catch (Exception e) {
            return Optional.empty();
        }
        
    }

    @Override
    public List<ProductModel> findAll() {
        return this.productRespository.findAll();
    }

    @Override
    public List<ProductModel> findAllByCategoryId(Long categoryId) {
        return this.productRespository.findByCategoryId(categoryId);
    }

}
