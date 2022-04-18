package com.oasis.smartink.controller;

import com.oasis.smartink.model.OrcamentoPiercing;
import com.oasis.smartink.repository.OrcamentoPiercingRepository;
import com.oasis.smartink.service.OrcamentoPiercingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orcamento")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class OrcamentoPiercingController {

    @Autowired
    OrcamentoPiercingService orcamentoPiercingService;

    @Autowired
    OrcamentoPiercingRepository orcamentoPiercingRepository;

    @PostMapping("/enviarOrcamentoPiercing")
    public ResponseEntity<OrcamentoPiercing> enviarOrcamentoTatuagem(@RequestBody OrcamentoPiercing orcamentoPiercing){

        OrcamentoPiercing saveOrcamento = orcamentoPiercingService.save(orcamentoPiercing);

        return ResponseEntity.status(HttpStatus.OK)
                             .body(saveOrcamento);
    }

}
