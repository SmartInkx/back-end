package com.oasis.smartink.service;

import com.oasis.smartink.model.OrcamentoPiercing;
import com.oasis.smartink.repository.OrcamentoPiercingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrcamentoPiercingService {

    @Autowired
    OrcamentoPiercingRepository orcamentoPiercingRepository;

    public OrcamentoPiercing save(OrcamentoPiercing orcamentoPiercing){
        try {
            return uploadOrcamentoPiercing(orcamentoPiercing);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private OrcamentoPiercing uploadOrcamentoPiercing(OrcamentoPiercing orcamentoPiercing) throws Exception {

        String nome = orcamentoPiercing.getNome();
        String celular = orcamentoPiercing.getCelular();
        String email = orcamentoPiercing.getEmail();
        String localEscolhido = orcamentoPiercing.getLocalEscolhido();

        OrcamentoPiercing buildOrcamentoPiercing = orcamentoPiercingRepository.saveAndFlush(new OrcamentoPiercing(nome, celular, email, localEscolhido));


        return buildOrcamentoPiercing;
    }

}
