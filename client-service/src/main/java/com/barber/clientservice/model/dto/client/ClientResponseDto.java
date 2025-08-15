package com.barber.clientservice.model.dto.client;

import java.util.Date;

import com.barber.clientservice.model.dto.user.UserResponseDto;

import lombok.Builder;

@Builder
public record ClientResponseDto(
        Long id,
        String name,
        String email,
        String cellphone,
        String document,
        Date birthdate,
        String adress,
        UserResponseDto user,
        Date createAt) {

}
