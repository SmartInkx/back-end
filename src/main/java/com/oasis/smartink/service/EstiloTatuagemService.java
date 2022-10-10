package com.oasis.smartink.service;

import com.oasis.smartink.model.EstiloTatuagem;
import com.oasis.smartink.repository.EstiloTatuagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstiloTatuagemService {

    @Autowired
    EstiloTatuagemRepository estiloTatuagemRepository;

    public EstiloTatuagem save(EstiloTatuagem estiloTatuagem){
        try {
            return uploadEstiloTatuagem(estiloTatuagem);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<EstiloTatuagem> getAll(){
        try {
            return getEstiloTatuagem();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private EstiloTatuagem uploadEstiloTatuagem(EstiloTatuagem estiloTatuagem) throws Exception {

        String tipo = estiloTatuagem.getTipo();

        EstiloTatuagem buildEstiloTatuagem = estiloTatuagemRepository.saveAndFlush(new EstiloTatuagem(tipo));

        return buildEstiloTatuagem;
    }

    private List<EstiloTatuagem> getEstiloTatuagem(){

        List<EstiloTatuagem> estiloTatuagem = estiloTatuagemRepository.findAll();

        return estiloTatuagem;
    }

}
