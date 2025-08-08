package com.barber.productcategoryservice.product_category_service.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barber.productcategoryservice.product_category_service.model.dto.CategoryResponseDto;
import com.barber.productcategoryservice.product_category_service.model.dto.ProductCategoryRequestDto;
import com.barber.productcategoryservice.product_category_service.service.ProductCategoryService;

import lombok.AllArgsConstructor;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@AllArgsConstructor
@RestController
@RequestMapping("/product-category-service")
public class ProductCategoryController {

    private final ProductCategoryService categoryService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getCategoryById(@PathVariable Long id) {
        try {
            CategoryResponseDto response = CategoryResponseDto
                    .toCategoryResponseDto(
                            this.categoryService.findById(id)
                                    .orElseThrow(() -> new Exception("El producto no existe")));
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            Map<String, Object> error = new HashMap<>();
            error.put("message", e.getMessage());
            error.put("date", new Date());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> postMethodName(@RequestBody ProductCategoryRequestDto body) {
        try {
            CategoryResponseDto responseDto = CategoryResponseDto.toCategoryResponseDto(
                    this.categoryService.save(
                            ProductCategoryRequestDto.toCategoryEntity(body))
                            .orElseThrow(() -> new Exception("Error al crear el product")));

            return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
        } catch (Exception e) {
            Map<String, Object> error = new HashMap<>();
            error.put("message", e.getMessage());
            error.put("date", new Date());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
        }
    }

}
