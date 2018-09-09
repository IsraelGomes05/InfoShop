package com.sistnet.projeto;

import java.util.Arrays;

import com.sistnet.projeto.domain.Cidade;
import com.sistnet.projeto.domain.Estado;
import com.sistnet.projeto.repository.CidadeRepository;
import com.sistnet.projeto.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sistnet.projeto.domain.Categoria;
import com.sistnet.projeto.domain.Produto;
import com.sistnet.projeto.repository.CategoriaRepository;
import com.sistnet.projeto.repository.ProdutoRepository;

@SpringBootApplication
public class AplicacaoJavaApplication implements CommandLineRunner {

    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private EstadoRepository estadoRepository;
    @Autowired
    private CidadeRepository cidadeRepository;

    public static void main(String[] args) {
        SpringApplication.run(AplicacaoJavaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Categoria cat1 = new Categoria(null, "Informárica");
        Categoria cat2 = new Categoria(null, "Escritório");

        Produto p1 = new Produto(null, "Computador", 2000.00);
        Produto p2 = new Produto(null, "Impressora", 800.00);
        Produto p3 = new Produto(null, "Mouse", 80.00);

        cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
        cat2.getProdutos().addAll(Arrays.asList(p2));

        p1.getCategorias().addAll(Arrays.asList(cat1));
        p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
        p3.getCategorias().addAll(Arrays.asList(cat1));

        categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
        produtoRepository.saveAll(Arrays.asList(p1, p2, p3));

        Estado estado = new Estado(null, "Minas Gerais");
        Estado estado1 = new Estado(null, "São Paulo");

        Cidade cidade = new Cidade(null, "Uberlândia", estado);
        Cidade cidade1 = new Cidade(null, "São Paulo", estado1);
        Cidade cidade2 = new Cidade(null, "Campinas", estado1);

        estado.getCidades().addAll(Arrays.asList(cidade));
        estado1.getCidades().addAll(Arrays.asList(cidade1,cidade2));

        estadoRepository.saveAll(Arrays.asList(estado, estado1));
        cidadeRepository.saveAll(Arrays.asList(cidade, cidade1, cidade2));
    }
}
