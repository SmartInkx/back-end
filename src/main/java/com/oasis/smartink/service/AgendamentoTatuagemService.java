package com.oasis.smartink.service;

import com.oasis.smartink.model.AgendamentoPiercing;
import com.oasis.smartink.model.AgendamentoTatuagem;
import com.oasis.smartink.model.EstiloTatuagem;
import com.oasis.smartink.repository.AgendamentoTatuagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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

    public Optional<AgendamentoTatuagem> updateAgendamentoTatuagem(Long id, AgendamentoTatuagem agendamentoTatuagem) {
        agendamentoTatuagemRepository.findById(id)
                                     .map(newAT -> {
                                         newAT.setData(agendamentoTatuagem.getData());
                                         newAT.setHorario(agendamentoTatuagem.getHorario());
                                         newAT.setLocalTatuagem(agendamentoTatuagem.getLocalTatuagem());
                                         newAT.setEstiloTatuagem(agendamentoTatuagem.getEstiloTatuagem());
                                         newAT.setNomeCliente(agendamentoTatuagem.getNomeCliente());
                                         newAT.setNomeProfissional(agendamentoTatuagem.getNomeProfissional());
                                         newAT.setTelefone(agendamentoTatuagem.getTelefone());
                                         newAT.setValor(agendamentoTatuagem.getValor());
                                         AgendamentoTatuagem updated = agendamentoTatuagemRepository.save(newAT);
                                         return updated;
                                     });

        Optional<AgendamentoTatuagem> agendamentoTatuagemById = agendamentoTatuagemRepository.findById(id);
        return agendamentoTatuagemById;
    }

    public void deleteAgendamentoPiercing(Long id){
        agendamentoTatuagemRepository.deleteById(id);
    }
}
