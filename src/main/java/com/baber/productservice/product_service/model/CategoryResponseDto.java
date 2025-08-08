package com.baber.productservice.product_service.model;

import java.util.Date;


import lombok.Builder;

@Builder
public record CategoryResponseDto(Long id, String name, boolean offer, Date initialAt, Date finalAt) {

}
