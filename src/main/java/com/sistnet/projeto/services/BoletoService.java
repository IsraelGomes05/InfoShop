package com.sistnet.projeto.services;

import com.sistnet.projeto.domain.PagamentoComBoleto;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

@Service
public class BoletoService {

    public void preencherPagamentoComBoleto(PagamentoComBoleto pgmt, Date instante) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(instante);
        calendar.add(Calendar.DAY_OF_MONTH, 7);
        pgmt.setDataVencimento(calendar.getTime());
    }
}
