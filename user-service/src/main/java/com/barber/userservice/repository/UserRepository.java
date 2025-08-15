package com.barber.userservice.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.barber.userservice.model.UserEntity;

public interface UserRepository extends MongoRepository<UserEntity,Long>{
    Optional<UserEntity> findByUsername(String username);
}
