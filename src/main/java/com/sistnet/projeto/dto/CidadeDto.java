package com.sistnet.projeto.dto;

import com.sistnet.projeto.domain.Cidade;

public class CidadeDto {

    private Integer id;
    private String nome;

    public CidadeDto() {
    }

    public CidadeDto(Cidade cidade) {
        this.id = cidade.getId();
        this.nome = cidade.getNome();
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

