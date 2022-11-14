package com.oasis.smartink.controller;

import com.oasis.smartink.model.AgendamentoPiercing;
import com.oasis.smartink.model.AgendamentoTatuagem;
import com.oasis.smartink.repository.AgendamentoTatuagemRepository;
import com.oasis.smartink.service.AgendamentoTatuagemService;
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

    @PutMapping(value="/{id}")
    public ResponseEntity updateAgendamentoTatuagem(@PathVariable("id") Long id,
                                               @RequestBody AgendamentoTatuagem agendamentoTatuagem) {
        Optional<AgendamentoTatuagem> result = agendamentoTatuagemService.updateAgendamentoTatuagem(id, agendamentoTatuagem);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteAgendamentoTatuagem(@PathVariable("id") Long id) {
        agendamentoTatuagemService.deleteAgendamentoPiercing(id);
        return ResponseEntity.status(HttpStatus.OK).body("Deletado com sucesso");
    }
}
