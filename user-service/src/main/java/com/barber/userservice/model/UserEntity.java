package com.barber.userservice.model;


import java.util.Random;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.barber.userservice.model.enums.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "user")
public class UserEntity {
    @Id
    private Long id;
    private String username;
    private String password;
    private Role role;
    
    public UserEntity(String username, String password, Role role) {
        this.id = new Random().nextLong(0, Long.MAX_VALUE);
        this.username = username;
        this.password = password;
        this.role = role;
    }


    
}
