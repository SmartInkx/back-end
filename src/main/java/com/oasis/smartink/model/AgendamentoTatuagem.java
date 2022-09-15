package com.oasis.smartink.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "agendamento_tatuagem")
public class AgendamentoTatuagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double valor;

    private Date horario;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "orcamento_tatuagem_id", referencedColumnName = "id",
                foreignKey = @ForeignKey(name = "id_orcamento_tatuagem"))
    private OrcamentoTatuagem orcamentoTatuagem;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "profissional_id", referencedColumnName = "id",
                foreignKey = @ForeignKey(name = "id_administrador_tatuagem"))
    private Administrador administradorProfissional;

    public AgendamentoTatuagem(Double valor, Date horario, OrcamentoTatuagem orcamentoTatuagem, Administrador administradorProfissional) {
        this.valor = valor;
        this.horario = horario;
        this.orcamentoTatuagem = orcamentoTatuagem;
        this.administradorProfissional = administradorProfissional;
    }
}
