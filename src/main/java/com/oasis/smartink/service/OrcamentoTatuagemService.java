package com.oasis.smartink.service;

import com.oasis.smartink.model.Files;
import com.oasis.smartink.model.OrcamentoTatuagem;
import com.oasis.smartink.repository.OrcamentoTatuagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class OrcamentoTatuagemService {

    @Autowired
    OrcamentoTatuagemRepository orcamentoTatuagemRepository;

    public OrcamentoTatuagem save(OrcamentoTatuagem orcamentoTatuagem){
        try {
            return uploadOrcamentoTatuagem(orcamentoTatuagem);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private OrcamentoTatuagem uploadOrcamentoTatuagem(OrcamentoTatuagem orcamentoTatuagem) throws Exception {

        String nome = orcamentoTatuagem.getNome();
        String celular = orcamentoTatuagem.getCelular();
        String email = orcamentoTatuagem.getEmail();
        String localEscolhido = orcamentoTatuagem.getLocalEscolhido();
        Files files = orcamentoTatuagem.getFiles();

        OrcamentoTatuagem buildOrcamentoTatuagem = orcamentoTatuagemRepository.saveAndFlush(new OrcamentoTatuagem(nome, celular, email, localEscolhido, files));


        return buildOrcamentoTatuagem;
    }

}
