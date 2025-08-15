package com.barber.clientservice.utils;

import java.util.Date;
import java.util.Random;

import com.barber.clientservice.model.dto.client.ClientRequestDto;
import com.barber.clientservice.model.dto.client.ClientResponseDto;
import com.barber.clientservice.model.dto.user.UserResponseDto;
import com.barber.clientservice.model.entity.ClientEntity;

public class ClientMapper {

    public static ClientResponseDto toClientResponse(ClientEntity client, UserResponseDto user) {
        return ClientResponseDto.builder()
                .id(client.getId())
                .name(client.getName())
                .email(client.getEmail())
                .document(client.getDocument())
                .cellphone(client.getCellphone())
                .adress(client.getAdress())
                .user(user)
                .birthdate(client.getBirthdate())
                .createAt(new Date())
                .build();
    }

    public static ClientEntity toClientEntity(ClientRequestDto request){

        return new ClientEntity(
            request.id() != null ? request.id() :  new Random().nextLong(0,Long.MAX_VALUE)
            , request.name()
            , request.email()
            , request.cellphone()
            , request.document()
            , request.birthdate()
            , request.adress()
            , request.user().id());

    }

    public static ClientEntity toClientEntity(ClientResponseDto response){

        return new ClientEntity(
            response.id() != null ? response.id() :  new Random().nextLong(0,Long.MAX_VALUE)
            , response.name()
            , response.email()
            , response.cellphone()
            , response.document()
            , response.birthdate()
            , response.adress()
            , response.user().id());

    }

}
