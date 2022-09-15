package com.oasis.smartink.service;

import com.oasis.smartink.model.Administrador;
import com.oasis.smartink.model.AgendamentoPiercing;
import com.oasis.smartink.model.AgendamentoTatuagem;
import com.oasis.smartink.model.OrcamentoPiercing;
import com.oasis.smartink.model.OrcamentoTatuagem;
import com.oasis.smartink.repository.AgendamentoPiercingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AgendamentoPiercingService {

    @Autowired
    AgendamentoPiercingRepository agendamentoPiercingRepository;

    public AgendamentoPiercing save(AgendamentoPiercing agendamentoPiercing){
        try {
            return uploadAgendamentoPiercing(agendamentoPiercing);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<AgendamentoPiercing> getAll(){
        try {
            return getAgendamentoPiercing();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private AgendamentoPiercing uploadAgendamentoPiercing(AgendamentoPiercing agendamentoPiercing) throws Exception {

        Double valor = agendamentoPiercing.getValor();
        OrcamentoPiercing orcamentoPiercing = agendamentoPiercing.getOrcamentoPiercing();
        Administrador administrador = agendamentoPiercing.getAdministradorProfissional();

        AgendamentoPiercing buildagendamentoPiercing = agendamentoPiercingRepository.saveAndFlush(new AgendamentoPiercing(valor, orcamentoPiercing, administrador));


        return buildagendamentoPiercing;
    }

    private List<AgendamentoPiercing> getAgendamentoPiercing(){

        List<AgendamentoPiercing> agendamentosPiercing = agendamentoPiercingRepository.findAll();

        return agendamentosPiercing;
    }
}
