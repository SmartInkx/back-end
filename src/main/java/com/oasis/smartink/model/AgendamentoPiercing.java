package com.oasis.smartink.model;

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
import javax.persistence.Table;
import java.util.Date;

@Builder
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "agendamento_piercing")
public class AgendamentoPiercing {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Double valor;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "orcamento_piercing_id", referencedColumnName = "uuid",
                foreignKey = @ForeignKey(name = "uuidOrcamento"))
    private OrcamentoPiercing orcamentoPiercing;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "profissional_id", referencedColumnName = "id",
                foreignKey = @ForeignKey(name = "idAdministrador"))
    private Administrador administradorProfissional;

    public AgendamentoPiercing(Double valor, OrcamentoPiercing orcamentoPiercing, Administrador administradorProfissional) {
        this.valor = valor;
        this.orcamentoPiercing = orcamentoPiercing;
        this.administradorProfissional = administradorProfissional;
    }
}
