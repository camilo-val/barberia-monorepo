package com.barber.userservice.service;

import java.util.Optional;

import com.barber.userservice.model.dto.UserRequestDto;
import com.barber.userservice.model.dto.UserResponseDto;

public interface UserService {
    Optional<UserResponseDto> save(UserRequestDto user);

    Optional<UserResponseDto> findById(Long id);

    Optional<UserResponseDto> findByUsername(String username);

    Optional<UserResponseDto> update(UserRequestDto user, Long id);

    boolean deleteById(Long id);

}
