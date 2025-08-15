package com.barber.employedservice.util;

import java.util.Date;
import java.util.Random;

import com.barber.employedservice.model.dto.employed.EmployedRequestDto;
import com.barber.employedservice.model.dto.employed.EmployedResponseDto;
import com.barber.employedservice.model.dto.user.UserResponseDto;
import com.barber.employedservice.model.entity.EmployedEntity;

import reactor.core.publisher.Mono;

public class EmployedMapper {

    public static Mono<EmployedResponseDto> toEmployedResponse(Mono<EmployedEntity> employed,
            UserResponseDto user) {
        return employed.map(
            employ -> {
                return EmployedResponseDto.builder()
                    .id(employ.getId())
                    .name(employ.getName())
                    .email(employ.getEmail())
                    .document(employ.getDocument())
                    .cellphone(employ.getCellphone())
                    .adress(employ.getAdress())
                    .user(user)
                    .birthdate(employ.getBirthdate())
                    .createAt(new Date())
                    .build();
            }
        );
             
    }

    public static EmployedResponseDto toEmployedResponse(EmployedEntity employed, UserResponseDto user) {

        return EmployedResponseDto.builder()
                .id(employed.getId())
                .name(employed.getName())
                .email(employed.getEmail())
                .document(employed.getDocument())
                .cellphone(employed.getCellphone())
                .adress(employed.getAdress())
                .user(user)
                .birthdate(employed.getBirthdate())
                .createAt(new Date())
                .build();

    }

        public static EmployedRequestDto toEmployedRequestDto(EmployedResponseDto employed) {

        return EmployedRequestDto.builder()
                .id(employed.id())
                .name(employed.name())
                .email(employed.email())
                .document(employed.document())
                .cellphone(employed.cellphone())
                .adress(employed.adress())
                .user(UserMapper.toUserRequest(employed.user()))
                .birthdate(employed.birthdate())
                .build();

    }


    public static EmployedEntity toEmployedEntity(EmployedRequestDto request, Long id) {
        return new EmployedEntity(
                request.id().equals(null)?new Random().nextLong(0, Long.MAX_VALUE): request.id(),
                request.name(), request.email(), request.cellphone(), request.document(), request.birthdate(),
                request.adress(), id);
    }

    public static EmployedEntity toEmployedEntity(EmployedRequestDto request) {
        return new EmployedEntity(
                request.id() == null ?new Random().nextLong(0, Long.MAX_VALUE): request.id(),
                request.name(), request.email(), request.cellphone(), request.document(), request.birthdate(),
                request.adress());
    }

}
