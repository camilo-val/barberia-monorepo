package com.barber.userservice.service.mapper;

import java.util.Date;

import com.barber.userservice.model.UserEntity;
import com.barber.userservice.model.dto.UserRequestDto;
import com.barber.userservice.model.dto.UserResponseDto;

public class UserMapper {
    public static UserResponseDto toResponse(UserEntity user){
        return UserResponseDto.builder()
        .id(user.getId())
        .username(user.getUsername())
        .password(user.getPassword())
        .role(user.getRole())
        .date(new Date())
        .build();
    }

    public static UserEntity toUserEntity(UserRequestDto requestDto){
        return new UserEntity(
         requestDto.username()
        , requestDto.password()
        , requestDto.role());
    }
}
