package com.barber.employedservice.model.dto.user;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;

@Builder
public record UserResponseDto(
        Long id,
        String username,
        @JsonIgnore
        String password,
        String role,
        Date date) {

}
