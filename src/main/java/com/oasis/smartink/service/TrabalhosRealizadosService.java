package com.oasis.smartink.service;

import com.oasis.smartink.model.AgendamentoPiercing;
import com.oasis.smartink.model.AgendamentoTatuagem;
import com.oasis.smartink.model.TrabalhosRealizados;
import com.oasis.smartink.repository.TrabalhosRealizadosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrabalhosRealizadosService {

    @Autowired
    TrabalhosRealizadosRepository trabalhosRealizadosRepository;

    public TrabalhosRealizados save(TrabalhosRealizados trabalhosRealizados){
        try {
            return uploadTrabalhosRealizados(trabalhosRealizados);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<TrabalhosRealizados> getAll(){
        try {
            return getTrabalhosRealizados();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private TrabalhosRealizados uploadTrabalhosRealizados(TrabalhosRealizados trabalhosRealizados) throws Exception {

        Long quantidadePiercing = trabalhosRealizados.getQuantidadePiercing();
        Long quantidadeTatuagem = trabalhosRealizados.getQuantidadeTatuagem();
        AgendamentoPiercing agendamentoPiercing = trabalhosRealizados.getAgendamentoPiercing();
        AgendamentoTatuagem agendamentoTatuagem = trabalhosRealizados.getAgendamentoTatuagem();

        TrabalhosRealizados buildTrabalhosRealizados = trabalhosRealizadosRepository.saveAndFlush(new TrabalhosRealizados(quantidadePiercing, quantidadeTatuagem, agendamentoTatuagem, agendamentoPiercing));

        return buildTrabalhosRealizados;
    }

    private List<TrabalhosRealizados> getTrabalhosRealizados(){

        List<TrabalhosRealizados> trabalhosRealizados = trabalhosRealizadosRepository.findAll();

        return trabalhosRealizados;
    }

    public Optional<TrabalhosRealizados> updateTrabalhosRealizados(Long id, TrabalhosRealizados trabalhosRealizados) {
        trabalhosRealizadosRepository.findById(id)
                                     .map(newTR -> {
                                         newTR.setQuantidadeTatuagem(trabalhosRealizados.getQuantidadeTatuagem());
                                         newTR.setQuantidadePiercing(trabalhosRealizados.getQuantidadePiercing());
                                         newTR.setAgendamentoTatuagem(trabalhosRealizados.getAgendamentoTatuagem());
                                         newTR.setAgendamentoPiercing(trabalhosRealizados.getAgendamentoPiercing());
                                         TrabalhosRealizados updated = trabalhosRealizadosRepository.save(newTR);
                                         return updated;
                                     });

        Optional<TrabalhosRealizados> trabalhosRealizadosById = trabalhosRealizadosRepository.findById(id);
        return trabalhosRealizadosById;
    }

    public void deleteTrabalhosRealizados(Long id){
        trabalhosRealizadosRepository.deleteById(id);
    }
}
