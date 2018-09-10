package com.sistnet.projeto.domain;

import com.sistnet.projeto.domain.enums.EstadoPagamento;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class PagamentoComBoleto extends Pagamento{

    private static final long serialVersionUID = 1L;

    private Date dataVencimento;
    private Date dataPagemento;

    public PagamentoComBoleto() {
    }

    public PagamentoComBoleto(Integer id, EstadoPagamento estadoPagamento, Pedido pedido, Date dataVencimento, Date dataPagemento) {
        super(id, estadoPagamento, pedido);
        this.dataVencimento = dataVencimento;
        this.dataPagemento = dataPagemento;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Date getDataPagemento() {
        return dataPagemento;
    }

    public void setDataPagemento(Date dataPagemento) {
        this.dataPagemento = dataPagemento;
    }
}
