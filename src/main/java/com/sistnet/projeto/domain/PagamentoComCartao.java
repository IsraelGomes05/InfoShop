package com.sistnet.projeto.domain;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.sistnet.projeto.domain.enums.EstadoPagamento;

import javax.persistence.Entity;

@Entity
@JsonTypeName("pagamentoComCartao")
public class PagamentoComCartao extends Pagamento {


    private static final long serialVersionUID = 1L;
    private Integer qtdDeParcelas;

    public PagamentoComCartao() {
    }

    public PagamentoComCartao(Integer id, EstadoPagamento estadoPagamento, Pedido pedido, Integer qtdDeParcelas) {
        super(id, estadoPagamento, pedido);
        this.qtdDeParcelas = qtdDeParcelas;
    }

    public Integer getQtdDeParcelas() {
        return qtdDeParcelas;
    }

    public void setQtdDeParcelas(Integer qtdDeParcelas) {
        this.qtdDeParcelas = qtdDeParcelas;
    }
}
