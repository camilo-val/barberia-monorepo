package com.barber.employedservice.service.user;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.barber.employedservice.model.UserModel;
import com.barber.employedservice.model.dto.user.UserRequestDto;
import com.barber.employedservice.model.dto.user.UserResponseDto;
import com.barber.employedservice.util.UserMapper;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService{

    private final WebClient.Builder builder;

    @Override
    public Mono<UserResponseDto> findById(Long id) {
        return this.builder.build()
        .get()
        .uri("/{id}", id)
        .accept(MediaType.APPLICATION_JSON)
        .retrieve()
        .bodyToMono(UserModel.class)
        .flatMap(user -> UserMapper.toUserResponse(user));
    }

    @Override
    public Mono<UserResponseDto> create(UserRequestDto userRequestDto) {
        return builder.build()
        .post()
        .uri("/create")
        .accept(MediaType.APPLICATION_JSON)
        .bodyValue(userRequestDto)
        .retrieve()
        .bodyToMono(UserModel.class)
        .flatMap(UserMapper::toUserResponse);
        
    }

    @Override
    public Mono<UserResponseDto> update(Long id, UserRequestDto userRequestDto) {
        return builder.build()
        .put()
        .uri("/update/{id}", id)
        .accept(MediaType.APPLICATION_JSON)
        .bodyValue(userRequestDto)
        .retrieve()
        .bodyToMono(UserModel.class)
        .flatMap(UserMapper::toUserResponse);
    }

}
