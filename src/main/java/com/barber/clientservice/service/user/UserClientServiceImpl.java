package com.barber.clientservice.service.user;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.barber.clientservice.model.UserModel;
import com.barber.clientservice.model.dto.user.UserRequestDto;
import com.barber.clientservice.model.dto.user.UserResponseDto;
import com.barber.clientservice.utils.UserMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserClientServiceImpl implements UserClientService {

    private final WebClient.Builder builder;
    private static final Logger logger = LoggerFactory.getLogger(UserClientService.class);
    @Override
    public Optional<UserResponseDto> findById(Long id) {
        return Optional.of(
                UserMapper.toUserResponse(
                        builder.build()
                                .get()
                                .uri("/{id}", id)
                                .accept(MediaType.APPLICATION_JSON)
                                .retrieve()
                                .bodyToMono(UserModel.class)
                                .block()));
    }

    @Override
    public Optional<UserResponseDto> findByUsername(String username) {
        return Optional.of(
                UserMapper.toUserResponse(
                        builder.build()
                                .get()
                                .uri("/username/{username}", username)
                                .accept(MediaType.APPLICATION_JSON)
                                .retrieve()
                                .bodyToMono(UserModel.class)
                                .block()));
    }

    @Override
    public Optional<UserResponseDto> createUser(UserRequestDto user) {
        return Optional.of(
                UserMapper.toUserResponse(
                        builder.build()
                                .post()
                                .uri("/create")
                                .accept(MediaType.APPLICATION_JSON)
                                .bodyValue(user)
                                .retrieve()
                                .bodyToMono(UserModel.class)
                                .block()));
    }

    @Override
    public Optional<UserResponseDto> updateUser(Long id, UserRequestDto user) {
        logger.info("id: " + id, "body: " + user);

        return Optional.of(
                UserMapper.toUserResponse(
                        builder.build()
                                .put()
                                .uri("/update/{id}", id)
                                .accept(MediaType.APPLICATION_JSON)
                                .bodyValue(user)
                                .retrieve()
                                .bodyToMono(UserModel.class)
                                .block()));
    }

}
