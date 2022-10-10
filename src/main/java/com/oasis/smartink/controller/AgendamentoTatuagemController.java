package com.oasis.smartink.controller;

import com.oasis.smartink.model.AgendamentoTatuagem;
import com.oasis.smartink.repository.AgendamentoTatuagemRepository;
import com.oasis.smartink.service.AgendamentoTatuagemService;
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
@RequestMapping("/agendamentotatuagem")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AgendamentoTatuagemController {

    @Autowired
    AgendamentoTatuagemService agendamentoTatuagemService;

    @GetMapping
    public ResponseEntity<List<AgendamentoTatuagem>> listarAgendamentosTatuagem(){
        List<AgendamentoTatuagem> agendamentosTatuagem = agendamentoTatuagemService.getAll();

        return new ResponseEntity<>(agendamentosTatuagem, HttpStatus.OK);
    }

    @PostMapping("/enviaragendamentotatuagem")
    public ResponseEntity<AgendamentoTatuagem> enviarAgendamentoTatuagem(@RequestBody AgendamentoTatuagem agendamentoTatuagem){

        AgendamentoTatuagem saveAgendamento = agendamentoTatuagemService.save(agendamentoTatuagem);

        return ResponseEntity.status(HttpStatus.OK)
                             .body(saveAgendamento);
    }
}
