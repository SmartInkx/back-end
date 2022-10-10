package com.oasis.smartink.controller;

import com.oasis.smartink.model.EstiloTatuagem;
import com.oasis.smartink.model.MaterialPiercing;
import com.oasis.smartink.service.EstiloTatuagemService;
import com.oasis.smartink.service.MaterialPiercingService;
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
@RequestMapping("/materialpiercing")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MaterialPiercingController {

    @Autowired
    MaterialPiercingService materialPiercingService;

    @GetMapping
    public ResponseEntity<List<MaterialPiercing>> listarMaterialPiercings(){
        List<MaterialPiercing> materialPiercings = materialPiercingService.getAll();

        return new ResponseEntity<>(materialPiercings, HttpStatus.OK);
    }

    @PostMapping("/enviarmaterialpiercing")
    public ResponseEntity<MaterialPiercing> enviarMaterialPiercing(@RequestBody MaterialPiercing materialPiercing){

        MaterialPiercing saveMaterialPiercing = materialPiercingService.save(materialPiercing);

        return ResponseEntity.status(HttpStatus.OK)
                             .body(saveMaterialPiercing);
    }

}
