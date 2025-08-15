package com.barber.employedservice.service.employed;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import com.barber.employedservice.Repository.EmployedRepository;
import com.barber.employedservice.model.dto.employed.EmployedRequestDto;
import com.barber.employedservice.model.dto.employed.EmployedResponseDto;
import com.barber.employedservice.model.dto.user.UserResponseDto;
import com.barber.employedservice.model.entity.EmployedEntity;
import com.barber.employedservice.service.user.UserService;
import com.barber.employedservice.util.EmployedMapper;
import com.barber.employedservice.util.UserMapper;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Service
public class EmployedServiceImpl implements EmployedService {

    private final EmployedRepository employedRepository;
    private final UserService userService;
    private final Logger logger = LoggerFactory.getLogger(EmployedServiceImpl.class);

    @Override
    public Mono<EmployedResponseDto> getById(Long id) {

        return this.employedRepository.findById(id).flatMap(
                e -> {
                    logger.info("Get Employed Entity: " + e + " " + EmployedServiceImpl.class.getName());
                    return this.userService.findById(e.getUserId()).map(
                            em -> {
                                logger.info("Get Employed : " + em + " " + EmployedServiceImpl.class.getName());

                                return EmployedMapper.toEmployedResponse(e, em);
                            });
                }

        );
    }

    @Override
    public Mono<EmployedResponseDto> save(EmployedRequestDto employed) {
        return this.userService.create(employed.user()).flatMap(
                u -> {
                    logger.info("create User: " + u + " " + EmployedServiceImpl.class.getName());
                    EmployedEntity et = EmployedMapper.toEmployedEntity(employed);
                    et.setUserId(u.id());
                    // return EmployedMapper.toEmployedResponse(this.employedRepository.save(et),u);
                    return this.employedRepository.save(et).map(empl -> {
                        logger.info("crete Employed: " + et + " " + EmployedServiceImpl.class.getName());
                        return EmployedMapper.toEmployedResponse(empl, u);
                    });
                });

    }

    @Override
    public Mono<EmployedResponseDto> update(Long id, EmployedRequestDto employed) {

        return Mono.zip(
                this.employedRepository.findById(id),
                this.userService.findById(employed.user().id()))
                .filter(tuple -> {
                    logger.info("Tuple : " + tuple.getT2() + " tuple 2: " + tuple.getT1() + " "
                            + tuple.getT2().id().equals(tuple.getT1().getUserId()));
                    return tuple.getT2().id().equals(tuple.getT1().getId());
                })
                .flatMap(tuple -> {
                    logger.info(
                            "1Update  Employed Entity: " + " aaaaa" + " " + EmployedServiceImpl.class.getName());
                    UserResponseDto user = tuple.getT2();
                    logger.info(
                            "1Update  Employed Entity: " + user + " " + EmployedServiceImpl.class.getName());
                    EmployedEntity updatedEmploy = EmployedMapper.toEmployedEntity(employed, user.id());
                    logger.info(
                            "Update  Employed Entity: " + updatedEmploy + " " + EmployedServiceImpl.class.getName());
                    logger.info("Update User: " + user + " " + EmployedServiceImpl.class.getName());

                    return this.userService.update(user.id(), UserMapper.toUserRequest(user))
                            .then(this.employedRepository.save(updatedEmploy))
                            .map(savedEmploy -> EmployedMapper.toEmployedResponse(savedEmploy, user));
                });

    }

    @Override
    public Flux<EmployedResponseDto> findAll() {
        return Flux.empty();
    }

}
