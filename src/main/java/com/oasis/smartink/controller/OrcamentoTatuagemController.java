package com.oasis.smartink.controller;

import com.oasis.smartink.model.OrcamentoTatuagem;
import com.oasis.smartink.repository.OrcamentoTatuagemRepository;
import com.oasis.smartink.service.OrcamentoTatuagemService;
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
@RequestMapping("/orcamentoTatuagem")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class OrcamentoTatuagemController {

    @Autowired
    OrcamentoTatuagemService orcamentoTatuagemService;

    @Autowired
    OrcamentoTatuagemRepository orcamentoTatuagemRepository;

    @GetMapping
    public ResponseEntity<List<OrcamentoTatuagem>> listarOrcamentosTatuagem(){
        List<OrcamentoTatuagem> orcamentosTatuagem = orcamentoTatuagemService.getAll();

        return new ResponseEntity<>(orcamentosTatuagem, HttpStatus.OK);
    }

    @PostMapping("/enviarOrcamentoTatuagem")
    public ResponseEntity<OrcamentoTatuagem> enviarOrcamentoTatuagem(@RequestBody OrcamentoTatuagem orcamentoTatuagem){

        OrcamentoTatuagem saveOrcamento = orcamentoTatuagemService.save(orcamentoTatuagem);

        return ResponseEntity.status(HttpStatus.OK)
                             .body(saveOrcamento);
    }

}
