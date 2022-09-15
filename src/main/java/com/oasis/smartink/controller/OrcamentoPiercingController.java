package com.oasis.smartink.controller;

import com.oasis.smartink.model.OrcamentoPiercing;
import com.oasis.smartink.repository.OrcamentoPiercingRepository;
import com.oasis.smartink.service.OrcamentoPiercingService;
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
@RequestMapping("/orcamentoPiercing")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class OrcamentoPiercingController {

    @Autowired
    OrcamentoPiercingService orcamentoPiercingService;

    @Autowired
    OrcamentoPiercingRepository orcamentoPiercingRepository;

    @GetMapping
    public ResponseEntity<List<OrcamentoPiercing>> listarOrcamentosPiercing(){
        List<OrcamentoPiercing> orcamentosPiercing = orcamentoPiercingService.getAll();

        return new ResponseEntity<>(orcamentosPiercing, HttpStatus.OK);
    }

    @PostMapping("/enviarOrcamentoPiercing")
    public ResponseEntity<OrcamentoPiercing> enviarOrcamentoTatuagem(@RequestBody OrcamentoPiercing orcamentoPiercing){

        OrcamentoPiercing saveOrcamento = orcamentoPiercingService.save(orcamentoPiercing);

        return ResponseEntity.status(HttpStatus.OK)
                             .body(saveOrcamento);
    }

}
