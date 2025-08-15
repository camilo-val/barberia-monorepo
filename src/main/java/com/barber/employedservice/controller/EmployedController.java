package com.barber.employedservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barber.employedservice.model.dto.employed.EmployedRequestDto;
import com.barber.employedservice.model.dto.employed.EmployedResponseDto;
import com.barber.employedservice.service.employed.EmployedService;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@RestController
@RequestMapping("/employed-service/api")
public class EmployedController {

    private final EmployedService employedService;

    @GetMapping("/{id}")
    public Mono<ResponseEntity<EmployedResponseDto>> getEmployedById(@PathVariable("id") Long id) {
        return this.employedService.getById(id).map(employed -> new ResponseEntity<>(employed, HttpStatus.OK))
                .onErrorResume(e -> Mono.just(ResponseEntity.internalServerError().build()));
    }

    @PostMapping("/create")
    public Mono<ResponseEntity<EmployedResponseDto>> createEmployed(@RequestBody EmployedRequestDto request) {
        return this.employedService.save(request)
                .map(newEmployed -> new ResponseEntity<>(newEmployed, HttpStatus.CREATED))
                .onErrorResume(
                        e -> Mono.just(ResponseEntity.internalServerError().build()));

    }

    @PutMapping("/update/{id}")
    public Mono<ResponseEntity<EmployedResponseDto>> updateEmployed(@PathVariable("id") Long id, @RequestBody EmployedRequestDto request) {
        return this.employedService.update(id,request)
                .map(newEmployed -> new ResponseEntity<>(newEmployed, HttpStatus.CREATED))
                .onErrorResume(
                        e -> Mono.just(ResponseEntity.internalServerError().build()));

    }
}
