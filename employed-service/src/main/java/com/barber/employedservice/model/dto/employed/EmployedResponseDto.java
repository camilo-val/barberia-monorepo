package com.barber.employedservice.model.dto.employed;

import java.util.Date;

import com.barber.employedservice.model.dto.user.UserResponseDto;

import lombok.Builder;

@Builder
public record EmployedResponseDto(
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
