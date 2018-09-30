package com.sistnet.projeto.dto;

import com.sistnet.projeto.domain.Estado;

import java.io.Serializable;

public class EstadoDto implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private String nome;

    public EstadoDto() {
    }

    public EstadoDto(Estado estado) {
        this.id = estado.getId();
        this.nome = estado.getNome();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
