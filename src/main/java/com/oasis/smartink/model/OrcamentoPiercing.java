package com.oasis.smartink.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;

@Entity
@Table(name = "orcamento_piercing")
public class OrcamentoPiercing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String celular;

    @Email
    private String email;

    @Column(name = "local_escolhido")
    private String localEscolhido;

    public OrcamentoPiercing(String nome, String celular, @Email String email, String localEscolhido) {
        this.nome = nome;
        this.celular = celular;
        this.email = email;
        this.localEscolhido = localEscolhido;
    }

    public OrcamentoPiercing() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocalEscolhido() {
        return localEscolhido;
    }

    public void setLocalEscolhido(String localEscolhido) {
        this.localEscolhido = localEscolhido;
    }

}
