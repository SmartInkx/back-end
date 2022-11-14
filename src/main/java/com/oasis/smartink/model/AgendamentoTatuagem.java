package com.oasis.smartink.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "agendamento_tatuagem")
public class AgendamentoTatuagem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;

    private String nomeCliente;

    private String nomeProfissional;

    private Double valor;

    private String localTatuagem;

    private String telefone;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate data;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
    private LocalTime horario;

    @OneToOne
    private EstiloTatuagem estiloTatuagem;

    public AgendamentoTatuagem(String nomeCliente, String nomeProfissional, Double valor, String localTatuagem, String telefone, LocalDate data, LocalTime horario, EstiloTatuagem estiloTatuagem) {
        this.nomeCliente = nomeCliente;
        this.nomeProfissional = nomeProfissional;
        this.valor = valor;
        this.localTatuagem = localTatuagem;
        this.telefone = telefone;
        this.data = data;
        this.horario = horario;
        this.estiloTatuagem = estiloTatuagem;
    }
}
