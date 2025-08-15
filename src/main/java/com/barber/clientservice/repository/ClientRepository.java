package com.barber.clientservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.barber.clientservice.model.entity.ClientEntity;

public interface ClientRepository extends MongoRepository<ClientEntity, Long>{

}
