package com.barber.userservice.model.dto;

import java.util.Date;

import com.barber.userservice.model.enums.Role;

import lombok.Builder;

@Builder
public record UserResponseDto(
    Long id,
    String username,
    String password,
    Role role,
    Date date
) {

}
