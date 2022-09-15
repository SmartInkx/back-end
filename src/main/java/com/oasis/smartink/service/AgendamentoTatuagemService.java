package com.oasis.smartink.service;

import com.oasis.smartink.model.Administrador;
import com.oasis.smartink.model.AgendamentoTatuagem;
import com.oasis.smartink.model.Files;
import com.oasis.smartink.model.OrcamentoTatuagem;
import com.oasis.smartink.repository.AgendamentoTatuagemRepository;
import com.oasis.smartink.repository.OrcamentoTatuagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AgendamentoTatuagemService {

    @Autowired
    AgendamentoTatuagemRepository agendamentoTatuagemRepository;

    public AgendamentoTatuagem save(AgendamentoTatuagem agendamentoTatuagem){
        try {
            return uploadAgendamentoTatuagem(agendamentoTatuagem);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<AgendamentoTatuagem> getAll(){
        try {
            return getAgendamentoTatuagem();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private AgendamentoTatuagem uploadAgendamentoTatuagem(AgendamentoTatuagem agendamentoTatuagem) throws Exception {

        Double valor = agendamentoTatuagem.getValor();
        Date horario = agendamentoTatuagem.getHorario();
        OrcamentoTatuagem orcamentoTatuagem = agendamentoTatuagem.getOrcamentoTatuagem();
        Administrador administrador = agendamentoTatuagem.getAdministradorProfissional();

        AgendamentoTatuagem buildAgendamentoTatuagem = agendamentoTatuagemRepository.saveAndFlush(new AgendamentoTatuagem(valor, horario, orcamentoTatuagem, administrador));


        return buildAgendamentoTatuagem;
    }

    private List<AgendamentoTatuagem> getAgendamentoTatuagem(){

        List<AgendamentoTatuagem> agendamentosTatuagem = agendamentoTatuagemRepository.findAll();

        return agendamentosTatuagem;
    }
}
