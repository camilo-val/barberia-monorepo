package com.barber.clientservice.utils;

import java.util.Random;

import com.barber.clientservice.model.UserModel;
import com.barber.clientservice.model.dto.user.UserRequestDto;
import com.barber.clientservice.model.dto.user.UserResponseDto;

public class UserMapper {
    public static UserResponseDto toUserResponse(UserModel user) {
        return UserResponseDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .password(user.getPassword())
                .role(user.getRole())
                .build();
    }

    public static UserModel toUserModel(UserRequestDto request) {
        Long id = request.id() != null ? request.id() : new Random().nextLong(0, Long.MAX_VALUE);
        return new UserModel(id, request.username(), request.password(), request.role());
    }
}
