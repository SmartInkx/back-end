package com.oasis.smartink.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "trabalhos_realizados")
public class TrabalhosRealizados {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long quantidadePiercing;

    private Long quantidadeTatuagem;

    @OneToOne(cascade = CascadeType.MERGE)
    private AgendamentoTatuagem agendamentoTatuagem;

    @OneToOne(cascade = CascadeType.MERGE)
    private AgendamentoPiercing agendamentoPiercing;

    public TrabalhosRealizados(Long quantidadePiercing, Long quantidadeTatuagem, AgendamentoTatuagem agendamentoTatuagem, AgendamentoPiercing agendamentoPiercing) {
        this.quantidadePiercing = quantidadePiercing;
        this.quantidadeTatuagem = quantidadeTatuagem;
        this.agendamentoTatuagem = agendamentoTatuagem;
        this.agendamentoPiercing = agendamentoPiercing;
    }
}
