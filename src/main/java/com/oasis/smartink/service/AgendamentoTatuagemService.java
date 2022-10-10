package com.oasis.smartink.service;

import com.oasis.smartink.model.AgendamentoTatuagem;
import com.oasis.smartink.model.EstiloTatuagem;
import com.oasis.smartink.repository.AgendamentoTatuagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
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
        String nomeCliente = agendamentoTatuagem.getNomeCliente();
        String nomeProfissional = agendamentoTatuagem.getNomeProfissional();
        String localTatuagem = agendamentoTatuagem.getLocalTatuagem();
        String telefone = agendamentoTatuagem.getTelefone();
        LocalTime horario = agendamentoTatuagem.getHorario();
        LocalDate data = agendamentoTatuagem.getData();
        EstiloTatuagem estiloTatuagem = agendamentoTatuagem.getEstiloTatuagem();



        AgendamentoTatuagem buildAgendamentoTatuagem = agendamentoTatuagemRepository.saveAndFlush(new AgendamentoTatuagem(nomeCliente, nomeProfissional, valor, localTatuagem, telefone, data,
                                                                                                                          horario, estiloTatuagem));


        return buildAgendamentoTatuagem;
    }

    private List<AgendamentoTatuagem> getAgendamentoTatuagem(){

        List<AgendamentoTatuagem> agendamentosTatuagem = agendamentoTatuagemRepository.findAll();

        return agendamentosTatuagem;
    }
}
