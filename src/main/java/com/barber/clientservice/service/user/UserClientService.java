package com.barber.clientservice.service.user;

import java.util.Optional;

import com.barber.clientservice.model.dto.user.UserRequestDto;
import com.barber.clientservice.model.dto.user.UserResponseDto;

public interface UserClientService {
    Optional<UserResponseDto> findById(Long id);
    Optional<UserResponseDto> findByUsername(String username);
    Optional<UserResponseDto> createUser(UserRequestDto user);
    Optional<UserResponseDto> updateUser(Long id, UserRequestDto user);
}
