package com.barber.userservice.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.barber.userservice.model.dto.UserRequestDto;
import com.barber.userservice.model.dto.UserResponseDto;
import com.barber.userservice.repository.UserRepository;
import com.barber.userservice.service.mapper.UserMapper;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public Optional<UserResponseDto> save(UserRequestDto user) {
        try {
            findByUsername(user.username()).ifPresent(us -> {
                throw new RuntimeException("Error");
            });
            return Optional.empty();
        } catch (Exception e) {
            return Optional.of(UserMapper.toResponse(userRepository
                    .save(UserMapper.toUserEntity(user))));
        }
    }

    @Override
    public Optional<UserResponseDto> findById(Long id) {
        return Optional.of(
                UserMapper.toResponse(
                        userRepository.findById(id).orElseThrow(() -> new RuntimeException("No existe el usuario"))));
    }

    @Override
    public Optional<UserResponseDto> findByUsername(String username) {
        return Optional.of(
                UserMapper.toResponse(
                        userRepository.findByUsername(username).orElseThrow()));
    }

    @Override
    public Optional<UserResponseDto> update(UserRequestDto user, Long id) {
        try {
            return this.userRepository.findById(id)
                    .map(userBd -> {
                        userBd = UserMapper.toUserEntity(user);
                        userBd.setId(id);
                        this.userRepository.save(userBd);
                        return UserMapper.toResponse(userBd);
                    });
        } catch (Exception e) {
            throw new RuntimeException("No existe el producto a actualizar");
        }
    }

    @Override
    public boolean deleteById(Long id) {
        Optional<UserResponseDto> user = findById(id);
        this.userRepository.deleteById(id);
        return user.isPresent();
    }

}
