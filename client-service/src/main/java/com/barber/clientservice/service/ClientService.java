package com.barber.clientservice.service;

import java.util.List;
import java.util.Optional;

import com.barber.clientservice.model.dto.client.ClientRequestDto;
import com.barber.clientservice.model.dto.client.ClientResponseDto;



public interface ClientService {

    Optional<ClientResponseDto> findById(Long id);

    List<ClientResponseDto> findAll();

    Optional<ClientResponseDto> create(ClientRequestDto request);

    Optional<ClientResponseDto> update(Long id, ClientRequestDto request);

    boolean delete(Long id);

}
