package com.barber.userservice.model.dto;

import com.barber.userservice.model.enums.Role;

import lombok.Builder;

@Builder
public record UserRequestDto(Long id,
    String username,
    String password,
    Role role) {
}
