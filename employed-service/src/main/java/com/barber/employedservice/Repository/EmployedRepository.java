package com.barber.employedservice.Repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.barber.employedservice.model.entity.EmployedEntity;

public interface EmployedRepository extends ReactiveMongoRepository<EmployedEntity,Long>{

}
