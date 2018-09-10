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

    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private EstadoRepository estadoRepository;
    @Autowired
    private CidadeRepository cidadeRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private PagamentoRepository pagamentoRepository;

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

        Cliente cliente = new Cliente(null, "Maria silva", "maria@gmail.com", "465656666", TipoCliente.PESSOA_FISICA);

        cliente.getTelefones().addAll(Arrays.asList("26262666", "51515ss"));

        Endereco endereco = new Endereco(null, "Rua flores", "300", "Apto 300", "Jardim", "2324434",cliente ,cidade);
        Endereco endereco1 = new Endereco(null, "Rua Matos", "212", "Apto 321", "Matão", "8678797",cliente ,cidade1);

        cliente.getEnderecos().addAll(Arrays.asList(endereco, endereco1));

        clienteRepository.saveAll(Arrays.asList(cliente));
        enderecoRepository.saveAll(Arrays.asList(endereco, endereco1));

        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy hh:mm");

        Pedido pedido = new Pedido(null, sdf.parse("30/09/2017 00:00"), cliente, endereco);
        Pedido pedido1 = new Pedido(null, sdf.parse("30/10/2018 00:00"), cliente, endereco1);

        Pagamento pagamento = new PagamentoComCartao(null, EstadoPagamento.QUITADO, pedido,6);
        pedido.setPagamento(pagamento);

        Pagamento pagamento1 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, pedido1, sdf.parse("20/10/2017 00:00"), null);
        pedido1.setPagamento(pagamento1);

        cliente.getPedidos().addAll(Arrays.asList(pedido, pedido1));

        pedidoRepository.saveAll(Arrays.asList(pedido, pedido1));

        pagamentoRepository.saveAll(Arrays.asList(pagamento, pagamento1));
    }
}
