package com.baber.productservice.product_service.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baber.productservice.product_service.model.dto.CategoryResponseDto;
import com.baber.productservice.product_service.service.CategoryClientService;

import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/product-service")
@AllArgsConstructor
public class CategoryController {

    private final CategoryClientService categoryClientService;

    @GetMapping("/category-id/{id}")
    public ResponseEntity<?> getCategory(@PathVariable Long id) {
        try {
            CategoryResponseDto response = this.categoryClientService.getCategory(id);
            System.out.println("Entree: " + id);
            return new ResponseEntity<>(response,HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }
    
}
