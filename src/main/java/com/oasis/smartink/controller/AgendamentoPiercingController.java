package com.oasis.smartink.controller;

import com.oasis.smartink.model.AgendamentoPiercing;
import com.oasis.smartink.model.EstiloTatuagem;
import com.oasis.smartink.repository.AgendamentoPiercingRepository;
import com.oasis.smartink.service.AgendamentoPiercingService;
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
@RequestMapping("/agendamentopiercing")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AgendamentoPiercingController {

    @Autowired
    AgendamentoPiercingService agendamentoPiercingService;

    @GetMapping
    public ResponseEntity<List<AgendamentoPiercing>> listarAgendamentosPiercing(){
        List<AgendamentoPiercing> agendamentosPiercing = agendamentoPiercingService.getAll();

        return new ResponseEntity<>(agendamentosPiercing, HttpStatus.OK);
    }

    @PostMapping("/enviaragendamentopiercing")
    public ResponseEntity<AgendamentoPiercing> enviarAgendamentoPiercing(@RequestBody AgendamentoPiercing agendamentoPiercing){

        AgendamentoPiercing saveAgendamento = agendamentoPiercingService.save(agendamentoPiercing);

        return ResponseEntity.status(HttpStatus.OK)
                             .body(saveAgendamento);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity updateAgendamentoPiercing(@PathVariable("id") Long id,
                                               @RequestBody AgendamentoPiercing agendamentoPiercing) {
        Optional<AgendamentoPiercing> result = agendamentoPiercingService.updateAgendamentoPiercing(id, agendamentoPiercing);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteAgendamentoPiercing(@PathVariable("id") Long id) {
        agendamentoPiercingService.deleteAgendamentoPiercing(id);
        return ResponseEntity.status(HttpStatus.OK).body("Deletado com sucesso");
    }

}
