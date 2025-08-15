package com.barber.clientservice.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barber.clientservice.model.dto.client.ClientRequestDto;
import com.barber.clientservice.model.dto.client.ClientResponseDto;
import com.barber.clientservice.service.ClientService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/client-service/api")
public class ClientController {
    private final ClientService clientService;

    @GetMapping("/{id}")
    public ResponseEntity<?> geClientById(@PathVariable("id") Long id) {
        try {
            ClientResponseDto response = this.clientService.findById(id)
                    .orElseThrow(() -> new Exception("No se encuetra el usuario"));
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            Map<String, Object> error = new HashMap<>();
            error.put("message", e.getMessage());
            error.put("date", new Date());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
        }
    }

    @GetMapping("/")
    public ResponseEntity<?> getClients() {
        try {
            List<ClientResponseDto> response = this.clientService.findAll();
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            Map<String, Object> error = new HashMap<>();
            error.put("message", e.getMessage());
            error.put("date", new Date());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> createClient(@RequestBody ClientRequestDto request) {

        try {
            ClientResponseDto response = this.clientService.create(request)
                    .orElseThrow(() -> new Exception("Error al crear el cliente"));
            return new ResponseEntity<>(response, HttpStatus.CREATED);

        } catch (Exception e) {
            Map<String, Object> error = new HashMap<>();
            error.put("message", e.getMessage());
            error.put("date", new Date());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
        }

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateClient(@PathVariable("id") Long id, @RequestBody ClientRequestDto request) {

        try {
            ClientResponseDto response = this.clientService.update(id,request)
                    .orElseThrow(() -> new Exception("Error al actualizar el cliente"));
            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (Exception e) {
            Map<String, Object> error = new HashMap<>();
            error.put("message", e.getMessage());
            error.put("date", new Date());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
        }

    }
}
