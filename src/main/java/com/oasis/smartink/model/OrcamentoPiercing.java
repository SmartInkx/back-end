package com.oasis.smartink.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import java.util.UUID;

@Entity
@Table(name = "orcamento_piercing")
public class OrcamentoPiercing {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID uuid;

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

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
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
