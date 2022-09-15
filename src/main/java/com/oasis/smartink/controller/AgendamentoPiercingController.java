package com.oasis.smartink.controller;

import com.oasis.smartink.model.AgendamentoPiercing;
import com.oasis.smartink.repository.AgendamentoPiercingRepository;
import com.oasis.smartink.service.AgendamentoPiercingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/agendamentoPiercing")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AgendamentoPiercingController {

    @Autowired
    AgendamentoPiercingService agendamentoPiercingService;

    @Autowired
    AgendamentoPiercingRepository agendamentoPiercingRepository;

    @GetMapping
    public ResponseEntity<List<AgendamentoPiercing>> listarAgendamentosPiercing(){
        List<AgendamentoPiercing> agendamentosPiercing = agendamentoPiercingService.getAll();

        return new ResponseEntity<>(agendamentosPiercing, HttpStatus.OK);
    }

    @PostMapping("/enviarAgendamentoPiercing")
    public ResponseEntity<AgendamentoPiercing> enviarAgendamentoPiercing(@RequestBody AgendamentoPiercing agendamentoPiercing){

        AgendamentoPiercing saveAgendamento = agendamentoPiercingService.save(agendamentoPiercing);

        return ResponseEntity.status(HttpStatus.OK)
                             .body(saveAgendamento);
    }

}
