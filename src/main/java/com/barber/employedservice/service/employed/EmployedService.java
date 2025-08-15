package com.barber.employedservice.service.employed;

import com.barber.employedservice.model.dto.employed.EmployedRequestDto;
import com.barber.employedservice.model.dto.employed.EmployedResponseDto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EmployedService {
    Mono<EmployedResponseDto> getById(Long id);

    Mono<EmployedResponseDto> save(EmployedRequestDto employed);

    Mono<EmployedResponseDto> update(Long id, EmployedRequestDto employed);

    Flux<EmployedResponseDto> findAll();

}
