package com.oasis.smartink.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "agendamento_piercing")
public class AgendamentoPiercing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;

    private String nomeCliente;

    private String nomeProfissional;

    private Double valor;

    private String localPiercing;

    private String telefone;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate data;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
    private LocalTime horario;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @MapsId("material_piercing_Id")
    private MaterialPiercing materialPiercing;


    public AgendamentoPiercing(String nomeCliente, String nomeProfissional, Double valor, String localPiercing, String telefone, LocalDate data, LocalTime horario, MaterialPiercing materialPiercing) {
        this.nomeCliente = nomeCliente;
        this.nomeProfissional = nomeProfissional;
        this.valor = valor;
        this.localPiercing = localPiercing;
        this.telefone = telefone;
        this.data = data;
        this.horario = horario;
        this.materialPiercing = materialPiercing;
    }
}
