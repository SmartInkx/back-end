package com.oasis.smartink.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "files")
public class Files {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "create_at")
    @JsonFormat(pattern = "dd=MM-yyyy HH:mm:ss")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @JsonFormat(pattern = "dd=MM-yyyy HH:mm:ss")
    private LocalDateTime updatedAt;

    private String filename;

    @Lob
    private byte[] data;

    private String type;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "referencia_id", referencedColumnName = "uuid",
                foreignKey = @ForeignKey(name = "uuidOrcamento"))
    private OrcamentoTatuagem orcamentoTatuagem;


    public Files(Long id, LocalDateTime createdAt, LocalDateTime updatedAt, String filename, byte[] data, String type/*, Usuario usuario*/) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.filename = filename;
        this.data = data;
        this.type = type;
        //this.usuario = usuario;
    }

    public Files(String filename, byte[] data, String type/*, Usuario usuario*/) {
        this.filename = filename;
        this.data = data;
        this.type = type;
        //this.usuario = usuario;
    }

    public Files() {
    }

    @PrePersist
    protected void onCreate(){
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

//    public Usuario getUsuario() {
//        return usuario;
//    }
//
//    public void setUsuario(Usuario usuario) {
//        this.usuario = usuario;
//    }
}
