package com.barber.employedservice.service.user;

import com.barber.employedservice.model.dto.user.UserRequestDto;
import com.barber.employedservice.model.dto.user.UserResponseDto;

import reactor.core.publisher.Mono;

public interface UserService {
    Mono<UserResponseDto> findById(Long id);

    Mono<UserResponseDto> create(UserRequestDto userRequestDto);

    Mono<UserResponseDto> update(Long id,UserRequestDto userRequestDto);
}
