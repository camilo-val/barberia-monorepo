package com.barber.employedservice.model.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "employ")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployedEntity {
   @Id
   private Long id;
   private String name;
   private String email;
   private String cellphone;
   private String document;
   private Date birthdate;
   private String adress;
   private Long userId;
   public EmployedEntity(Long id, String name, String email, String cellphone, String document, Date birthdate,
         String adress) {
      this.id = id;
      this.name = name;
      this.email = email;
      this.cellphone = cellphone;
      this.document = document;
      this.birthdate = birthdate;
      this.adress = adress;
   }

   
}
