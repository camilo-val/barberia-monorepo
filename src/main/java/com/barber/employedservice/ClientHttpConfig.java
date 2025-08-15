package com.barber.employedservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;


@Configuration
public class ClientHttpConfig {

    @Value("${client.user.url}")
    private String url;

    @Bean
    @LoadBalanced
    public WebClient.Builder builder(){
        return WebClient.builder().baseUrl(url);
    }
}
