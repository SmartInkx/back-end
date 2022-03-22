package com.oasis.smartink.controller;

import com.oasis.smartink.model.Administrador;
import com.oasis.smartink.repository.AdministradorRepository;
import io.swagger.models.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/administradores")
public class AdministradorController {

    @Autowired
    private AdministradorRepository repository;

    @PostMapping("/cadastrar")
    public ResponseEntity<Administrador> Post(@RequestBody Administrador administrador){
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(administrador));
    }

}
