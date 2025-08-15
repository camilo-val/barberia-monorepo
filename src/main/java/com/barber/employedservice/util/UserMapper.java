package com.barber.employedservice.util;

import java.util.Random;

import com.barber.employedservice.model.UserModel;
import com.barber.employedservice.model.dto.user.UserRequestDto;
import com.barber.employedservice.model.dto.user.UserResponseDto;

import reactor.core.publisher.Mono;

public class UserMapper {
    public static Mono<UserResponseDto> toUserResponse(UserModel user) {
        return Mono.just(UserResponseDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .password(user.getPassword())
                .role(user.getRole())
                .build());
    }

    public static Mono<UserResponseDto> toUserResponse(UserRequestDto request) {
        return Mono.just(
                UserResponseDto.builder()
                        .id(request.id())
                        .username(request.username())
                        .password(request.password())
                        .role(request.role())
                        .build());

    }

    public static UserRequestDto toUserRequest(UserResponseDto responseDto) {

        return UserRequestDto.builder()
                .id(responseDto.id())
                .username(responseDto.username())
                .password(responseDto.password())
                .role(responseDto.role())
                .build();

    }

    public static UserModel toUserModel(UserRequestDto request) {
        Long id = request.id() != null ? request.id() : new Random().nextLong(0, Long.MAX_VALUE);
        return new UserModel(id, request.username(), request.password(), request.role());
    }
}
