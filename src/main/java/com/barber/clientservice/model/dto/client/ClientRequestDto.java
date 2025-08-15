package com.barber.clientservice.model.dto.client;

import java.util.Date;

import com.barber.clientservice.model.dto.user.UserRequestDto;

public record ClientRequestDto(
                Long id,
                String name,
                String email,
                String cellphone,
                String document,
                Date birthdate,
                String adress,
                UserRequestDto user) {

}
