package com.oasis.smartink.service;

import com.oasis.smartink.model.AgendamentoPiercing;
import com.oasis.smartink.model.MaterialPiercing;
import com.oasis.smartink.repository.AgendamentoPiercingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
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
        String nomeCliente = agendamentoPiercing.getNomeCliente();
        String nomeProfissional = agendamentoPiercing.getNomeProfissional();
        String localPiercing = agendamentoPiercing.getLocalPiercing();
        String telefone = agendamentoPiercing.getTelefone();
        LocalTime horario = agendamentoPiercing.getHorario();
        LocalDate data = agendamentoPiercing.getData();
        MaterialPiercing materialPiercing = agendamentoPiercing.getMaterialPiercing();

        AgendamentoPiercing buildagendamentoPiercing = agendamentoPiercingRepository.saveAndFlush(new AgendamentoPiercing(nomeCliente, nomeProfissional, valor, localPiercing, telefone, data, horario,
                                                                                                                          materialPiercing));

        return buildagendamentoPiercing;
    }

    private List<AgendamentoPiercing> getAgendamentoPiercing(){

        List<AgendamentoPiercing> agendamentosPiercing = agendamentoPiercingRepository.findAll();

        return agendamentosPiercing;
    }
}
