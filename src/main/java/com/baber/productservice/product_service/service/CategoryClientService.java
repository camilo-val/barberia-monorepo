package com.baber.productservice.product_service.service;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.baber.productservice.product_service.model.dto.CategoryResponseDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CategoryClientService {

    final WebClient.Builder builder;

    public CategoryResponseDto getCategory(Long id){
        return builder.build()
        .get()
        .uri("/" + id)
        .accept(MediaType.APPLICATION_JSON)
        .retrieve()
        .bodyToMono(CategoryResponseDto.class)
        .block();
    }
}
