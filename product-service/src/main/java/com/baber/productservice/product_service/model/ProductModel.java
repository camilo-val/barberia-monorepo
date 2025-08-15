package com.baber.productservice.product_service.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "product")
public class ProductModel {
    @Id
    private Long id;
    private String name;
    private Long categoryId;
    private double price;
    private Date createAt;
    private Date expirationAt;
}
