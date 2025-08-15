package com.barber.clientservice.model.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "client")
public class ClientEntity {
    @Id
    private Long id;
    private String name;
    private String email;
    private String cellphone;
    private String document;
    private Date birthdate;
    private String adress;
    private Long userId;
}
