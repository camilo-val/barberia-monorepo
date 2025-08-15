package com.baber.productservice.product_service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class ClientHttpConfiguration {

    @Value("${client.product-category-service.base-url}")
    private String url;

    @Bean
    @LoadBalanced
    public WebClient.Builder builder(){
        return WebClient.builder().baseUrl(url);
    }
}
