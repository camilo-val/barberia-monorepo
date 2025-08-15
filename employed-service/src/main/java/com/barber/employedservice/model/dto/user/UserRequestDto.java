package com.barber.employedservice.model.dto.user;

import lombok.Builder;

@Builder
public record UserRequestDto(
        Long id,
        String username,
        String password,
        String role) {

}
