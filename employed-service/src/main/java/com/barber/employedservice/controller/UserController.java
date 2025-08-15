package com.barber.employedservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barber.employedservice.model.dto.user.UserResponseDto;
import com.barber.employedservice.service.user.UserService;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@RestController
@RequestMapping("/employed-service")
public class UserController {

    private final UserService service;

    @GetMapping("/{id}")
    public Mono<ResponseEntity<UserResponseDto>> getUserById(@PathVariable("id") Long id) {
        return service.findById(id).map(user -> new ResponseEntity<>(user, HttpStatus.OK))
                .onErrorResume(e -> Mono.just(ResponseEntity.notFound().build()));
    }

}
