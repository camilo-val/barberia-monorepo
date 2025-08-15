package com.barber.productcategoryservice.product_category_service.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "product-category")
public class ProductCategoryEntity {
    @Id
    private Long id;
    private String name;
    private boolean offer;
    private Date initAt;
    private Date finalAt;
}
