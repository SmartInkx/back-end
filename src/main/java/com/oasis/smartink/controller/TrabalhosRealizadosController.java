package com.oasis.smartink.controller;

import com.oasis.smartink.model.MaterialPiercing;
import com.oasis.smartink.model.TrabalhosRealizados;
import com.oasis.smartink.service.MaterialPiercingService;
import com.oasis.smartink.service.TrabalhosRealizadosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/trabalhosrealizados")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TrabalhosRealizadosController {

    @Autowired
    TrabalhosRealizadosService trabalhosRealizadosService;

    @GetMapping
    public ResponseEntity<List<TrabalhosRealizados>> listarTrabalhosRealizados(){
        List<TrabalhosRealizados> trabalhosRealizados = trabalhosRealizadosService.getAll();

        return new ResponseEntity<>(trabalhosRealizados, HttpStatus.OK);
    }

    @PostMapping("/enviartrabalhosrealizados")
    public ResponseEntity<TrabalhosRealizados> enviarTrabalhosRealizados(@RequestBody TrabalhosRealizados trabalhosRealizados){

        TrabalhosRealizados saveTrabalhosRealizados = trabalhosRealizadosService.save(trabalhosRealizados);

        return ResponseEntity.status(HttpStatus.CREATED)
                             .body(saveTrabalhosRealizados);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity updateTrabalhosRealizados(@PathVariable("id") Long id,
                                                 @RequestBody TrabalhosRealizados trabalhosRealizados) {
        Optional<TrabalhosRealizados> result = trabalhosRealizadosService.updateTrabalhosRealizados(id, trabalhosRealizados);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteTrabalhosRealizados(@PathVariable("id") Long id) {
        trabalhosRealizadosService.deleteTrabalhosRealizados(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
