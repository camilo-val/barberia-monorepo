package com.barber.employedservice.model.dto.employed;

import java.util.Date;

import com.barber.employedservice.model.dto.user.UserRequestDto;

import lombok.Builder;

@Builder
public record EmployedRequestDto(
                Long id,
                String name,
                String email,
                String cellphone,
                String document,
                Date birthdate,
                String adress,
                UserRequestDto user) {

}
