package com.baber.productservice.product_service.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baber.productservice.product_service.model.ProductModel;
import com.baber.productservice.product_service.model.dto.ProductRequestDto;
import com.baber.productservice.product_service.model.dto.ProductResponseDto;
import com.baber.productservice.product_service.service.ProductService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/product-service/api")
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable("id") Long id) {
        try {
            ProductResponseDto response = ProductResponseDto.tResponseDto(this.productService
                    .findById(id)
                    .orElseThrow(() -> new Exception("No se ha encontrado el product")));
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            Map<String, Object> error = new HashMap<>();
            error.put("message", e.getMessage());
            error.put("date", new Date());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
        }
    }

    @GetMapping("/")
    public ResponseEntity<?> getProducts() {
        List<ProductModel> products = this.productService.findAll();
        List<ProductResponseDto> response = new ArrayList<>();
        products.forEach(p -> response.add(ProductResponseDto.tResponseDto(p)));
        if (!products.isEmpty()) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        Map<String, Object> error = new HashMap<>();
        error.put("message", "No ese han encontrado productos");
        error.put("date", new Date());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<?> getProductsByCategory(@PathVariable("id") Long id) {
        List<ProductModel> products = this.productService.findAllByCategoryId(id);
        List<ProductResponseDto> response = new ArrayList<>();
        products.forEach(p -> response.add(ProductResponseDto.tResponseDto(p)));
        if (!products.isEmpty()) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        Map<String, Object> error = new HashMap<>();
        error.put("message", "No ese han encontrado productos");
        error.put("date", new Date());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createProduct(@RequestBody ProductRequestDto request) {
        try {
            ProductResponseDto response = ProductResponseDto.tResponseDto(
                this.productService.save(ProductRequestDto.asProductModel(request)).orElseThrow(() -> new Exception("Error al crear el producto"))
            );
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            Map<String, Object> error = new HashMap<>();
            error.put("message", e.getMessage());
            error.put("date", new Date());
            return ResponseEntity.internalServerError().body(error);
        }
    }

}
