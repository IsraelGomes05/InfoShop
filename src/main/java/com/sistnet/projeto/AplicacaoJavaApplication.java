package com.sistnet.projeto;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import com.sistnet.projeto.domain.*;
import com.sistnet.projeto.domain.enums.EstadoPagamento;
import com.sistnet.projeto.domain.enums.TipoCliente;
import com.sistnet.projeto.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AplicacaoJavaApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(AplicacaoJavaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
