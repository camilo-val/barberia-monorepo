package com.barber.clientservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.barber.clientservice.model.dto.client.ClientRequestDto;
import com.barber.clientservice.model.dto.client.ClientResponseDto;
import com.barber.clientservice.model.dto.user.UserResponseDto;
import com.barber.clientservice.model.entity.ClientEntity;
import com.barber.clientservice.repository.ClientRepository;
import com.barber.clientservice.service.user.UserClientService;
import com.barber.clientservice.utils.ClientMapper;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final UserClientService clientService;
    private static Logger logger = LoggerFactory.getLogger(ClientServiceImpl.class);
    @Override
    public Optional<ClientResponseDto> findById(Long id) {
        ClientEntity client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No existe el cliente"));
       logger.info("Cliente: " + client);
        return Optional.of(
                ClientMapper.toClientResponse(
                        client,
                        this.clientService.findById(client.getUserId()).get()));
    }

    @Override
    public List<ClientResponseDto> findAll() {
        List<ClientResponseDto> client = new ArrayList<>();
        this.clientRepository.findAll().forEach(c -> client.add(ClientMapper.toClientResponse(c, null)));
        return client;
    }

    @Override
    public Optional<ClientResponseDto> create(ClientRequestDto request) {
        UserResponseDto newUSer = this.clientService.createUser(
                request.user())
                .orElseThrow(() -> new RuntimeException("Error al crear el usuario"));
        ClientEntity newClient = ClientMapper.toClientEntity(request);
        newClient.setUserId(newUSer.id());
        return Optional.of(
                ClientMapper.toClientResponse(
                        this.clientRepository.save(newClient),
                        newUSer));
    }

    @Override
    public Optional<ClientResponseDto> update(Long id, ClientRequestDto request) {
        ClientEntity getClient = ClientMapper
                .toClientEntity(findById(id).orElseThrow(() -> new RuntimeException("No existe el cliente")));

        UserResponseDto getUser = this.clientService.findById(getClient.getUserId())
                .orElseThrow(() -> new RuntimeException("No existe el usuario"));

        return Optional.of(getClient).filter(c -> c.getUserId().equals(getUser.id())).map(c -> {
            ClientEntity updateClient = ClientMapper.toClientEntity(request);
            updateClient.setId(c.getId());
            updateClient.setUserId(c.getUserId());
            return ClientMapper.toClientResponse(this.clientRepository.save(updateClient),
                    this.clientService.updateUser(c.getUserId(), request.user()).get());
        });
    }

    @Override
    public boolean delete(Long id) {
        return true;
    }

}
