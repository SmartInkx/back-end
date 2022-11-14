package com.oasis.smartink.controller;

import com.oasis.smartink.model.EstiloTatuagem;
import com.oasis.smartink.model.MaterialPiercing;
import com.oasis.smartink.service.EstiloTatuagemService;
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
@RequestMapping("/tipotatuagem")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EstiloTatuagemController {

    @Autowired
    EstiloTatuagemService estiloTatuagemService;

    @GetMapping
    public ResponseEntity<List<EstiloTatuagem>> listarEstilosTatuagem(){
        List<EstiloTatuagem> estiloTatuagens = estiloTatuagemService.getAll();

        return new ResponseEntity<>(estiloTatuagens, HttpStatus.OK);
    }

    @PostMapping("/enviartipotatuagem")
    public ResponseEntity<EstiloTatuagem> enviarTipoTatuagem(@RequestBody EstiloTatuagem estiloTatuagem){

        EstiloTatuagem saveEstiloTatuagem = estiloTatuagemService.save(estiloTatuagem);

        return ResponseEntity.status(HttpStatus.OK)
                             .body(saveEstiloTatuagem);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity updateEstiloTatuagem(@PathVariable("id") Long id,
                                                 @RequestBody EstiloTatuagem estiloTatuagem) {
        Optional<EstiloTatuagem> result = estiloTatuagemService.updateEstiloTatuagem(id, estiloTatuagem);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteEstiloTatuagem(@PathVariable("id") Long id) {
        estiloTatuagemService.deleteEstiloTatuagem(id);
        return ResponseEntity.status(HttpStatus.OK).body("Deletado com sucesso");
    }
}
