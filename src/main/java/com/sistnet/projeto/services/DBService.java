package com.sistnet.projeto.services;

import com.sistnet.projeto.domain.*;
import com.sistnet.projeto.domain.enums.EstadoPagamento;
import com.sistnet.projeto.domain.enums.Perfil;
import com.sistnet.projeto.domain.enums.TipoCliente;
import com.sistnet.projeto.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private BCryptPasswordEncoder encoder;
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
    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    public void instantiateDataBase() throws ParseException {

        Categoria cat1 = new Categoria(null, "Informática");
        Categoria cat2 = new Categoria(null, "Escritório");
        Categoria cat3 = new Categoria(null, "Cama mesa e banho");
        Categoria cat4 = new Categoria(null, "Eletrônicos");
        Categoria cat5 = new Categoria(null, "Jardinagem");
        Categoria cat6 = new Categoria(null, "Decoração");
        Categoria cat7 = new Categoria(null, "Perfumaria");

        Produto p1 = new Produto(null, "Computador", 2000.00);
        Produto p2 = new Produto(null, "Impressora", 800.00);
        Produto p3 = new Produto(null, "Mouse", 80.00);
        Produto p4 = new Produto(null, "Mesa de escritório", 300.00);
        Produto p5 = new Produto(null, "Toalha", 50.00);
        Produto p6 = new Produto(null, "Colcha", 200.00);
        Produto p7 = new Produto(null, "TV true color", 1200.00);
        Produto p8 = new Produto(null, "Roçadeira", 800.00);
        Produto p9 = new Produto(null, "Abajour", 100.00);
        Produto p10 = new Produto(null, "Pendente", 180.00);
        Produto p11 = new Produto(null, "Shampoo", 90.00);

        Produto p12 = new Produto(null, "Produto 12", 10.00);
        Produto p13 = new Produto(null, "Produto 13", 10.00);
        Produto p14 = new Produto(null, "Produto 14", 10.00);
        Produto p15 = new Produto(null, "Produto 15", 10.00);
        Produto p16 = new Produto(null, "Produto 16", 10.00);
        Produto p17 = new Produto(null, "Produto 17", 10.00);
        Produto p18 = new Produto(null, "Produto 18", 10.00);
        Produto p19 = new Produto(null, "Produto 19", 10.00);
        Produto p20 = new Produto(null, "Produto 20", 10.00);
        Produto p21 = new Produto(null, "Produto 21", 10.00);
        Produto p22 = new Produto(null, "Produto 22", 10.00);
        Produto p23 = new Produto(null, "Produto 23", 10.00);
        Produto p24 = new Produto(null, "Produto 24", 10.00);
        Produto p25 = new Produto(null, "Produto 25", 10.00);
        Produto p26 = new Produto(null, "Produto 26", 10.00);
        Produto p27 = new Produto(null, "Produto 27", 10.00);
        Produto p28 = new Produto(null, "Produto 28", 10.00);
        Produto p29 = new Produto(null, "Produto 29", 10.00);
        Produto p30 = new Produto(null, "Produto 30", 10.00);
        Produto p31 = new Produto(null, "Produto 31", 10.00);
        Produto p32 = new Produto(null, "Produto 32", 10.00);
        Produto p33 = new Produto(null, "Produto 33", 10.00);
        Produto p34 = new Produto(null, "Produto 34", 10.00);
        Produto p35 = new Produto(null, "Produto 35", 10.00);
        Produto p36 = new Produto(null, "Produto 36", 10.00);
        Produto p37 = new Produto(null, "Produto 37", 10.00);
        Produto p38 = new Produto(null, "Produto 38", 10.00);
        Produto p39 = new Produto(null, "Produto 39", 10.00);
        Produto p40 = new Produto(null, "Produto 40", 10.00);
        Produto p41 = new Produto(null, "Produto 41", 10.00);
        Produto p42 = new Produto(null, "Produto 42", 10.00);
        Produto p43 = new Produto(null, "Produto 43", 10.00);
        Produto p44 = new Produto(null, "Produto 44", 10.00);
        Produto p45 = new Produto(null, "Produto 45", 10.00);
        Produto p46 = new Produto(null, "Produto 46", 10.00);
        Produto p47 = new Produto(null, "Produto 47", 10.00);
        Produto p48 = new Produto(null, "Produto 48", 10.00);
        Produto p49 = new Produto(null, "Produto 49", 10.00);
        Produto p50 = new Produto(null, "Produto 50", 10.00);

        cat1.getProdutos().addAll(Arrays.asList(p12, p13, p14, p15, p16, p17, p18, p19, p20,
                p21, p22, p23, p24, p25, p26, p27, p28, p29, p30, p31, p32, p34, p35, p36, p37, p38,
                p39, p40, p41, p42, p43, p44, p45, p46, p47, p48, p49, p50));

        p12.getCategorias().add(cat1);
        p13.getCategorias().add(cat1);
        p14.getCategorias().add(cat1);
        p15.getCategorias().add(cat1);
        p16.getCategorias().add(cat1);
        p17.getCategorias().add(cat1);
        p18.getCategorias().add(cat1);
        p19.getCategorias().add(cat1);
        p20.getCategorias().add(cat1);
        p21.getCategorias().add(cat1);
        p22.getCategorias().add(cat1);
        p23.getCategorias().add(cat1);
        p24.getCategorias().add(cat1);
        p25.getCategorias().add(cat1);
        p26.getCategorias().add(cat1);
        p27.getCategorias().add(cat1);
        p28.getCategorias().add(cat1);
        p29.getCategorias().add(cat1);
        p30.getCategorias().add(cat1);
        p31.getCategorias().add(cat1);
        p32.getCategorias().add(cat1);
        p33.getCategorias().add(cat1);
        p34.getCategorias().add(cat1);
        p35.getCategorias().add(cat1);
        p36.getCategorias().add(cat1);
        p37.getCategorias().add(cat1);
        p38.getCategorias().add(cat1);
        p39.getCategorias().add(cat1);
        p40.getCategorias().add(cat1);
        p41.getCategorias().add(cat1);
        p42.getCategorias().add(cat1);
        p43.getCategorias().add(cat1);
        p44.getCategorias().add(cat1);
        p45.getCategorias().add(cat1);
        p46.getCategorias().add(cat1);
        p47.getCategorias().add(cat1);
        p48.getCategorias().add(cat1);
        p49.getCategorias().add(cat1);
        p50.getCategorias().add(cat1);


        cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
        cat2.getProdutos().addAll(Arrays.asList(p2));

        p1.getCategorias().addAll(Arrays.asList(cat1));
        p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
        p3.getCategorias().addAll(Arrays.asList(cat1));
        cat2.getProdutos().addAll(Arrays.asList(p2, p4));
        cat3.getProdutos().addAll(Arrays.asList(p5, p6));
        cat4.getProdutos().addAll(Arrays.asList(p1, p2, p3, p7));
        cat5.getProdutos().addAll(Arrays.asList(p8));
        cat6.getProdutos().addAll(Arrays.asList(p9, p10));
        cat7.getProdutos().addAll(Arrays.asList(p11));

        p1.getCategorias().addAll(Arrays.asList(cat1, cat4));
        p2.getCategorias().addAll(Arrays.asList(cat1, cat2, cat4));
        p3.getCategorias().addAll(Arrays.asList(cat1, cat4));
        p4.getCategorias().addAll(Arrays.asList(cat2));
        p5.getCategorias().addAll(Arrays.asList(cat3));
        p6.getCategorias().addAll(Arrays.asList(cat3));
        p7.getCategorias().addAll(Arrays.asList(cat4));
        p8.getCategorias().addAll(Arrays.asList(cat5));
        p9.getCategorias().addAll(Arrays.asList(cat6));
        p10.getCategorias().addAll(Arrays.asList(cat6));
        p11.getCategorias().addAll(Arrays.asList(cat7));

        categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7));
        produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11));

        produtoRepository.saveAll(Arrays.asList(p12, p13, p14, p15, p16, p17, p18, p19, p20,
                p21, p22, p23, p24, p25, p26, p27, p28, p29, p30, p31, p32, p34, p35, p36, p37, p38,
                p39, p40, p41, p42, p43, p44, p45, p46, p47, p48, p49, p50));

        Estado estado = new Estado(null, "Minas Gerais");
        Estado estado1 = new Estado(null, "São Paulo");

        Cidade cidade = new Cidade(null, "Uberlândia", estado);
        Cidade cidade1 = new Cidade(null, "São Paulo", estado1);
        Cidade cidade2 = new Cidade(null, "Campinas", estado1);

        estado.getCidades().addAll(Arrays.asList(cidade));
        estado1.getCidades().addAll(Arrays.asList(cidade1, cidade2));

        estadoRepository.saveAll(Arrays.asList(estado, estado1));
        cidadeRepository.saveAll(Arrays.asList(cidade, cidade1, cidade2));

        Cliente cliente = new Cliente(null, "Israel gomes", "israelgomes05@gmail.com", "465656666", TipoCliente.PESSOA_FISICA, encoder.encode("122"));
        Cliente cliente1 = new Cliente(null, "Ana silva", "israelsilva05@hotmail.com", "465656626", TipoCliente.PESSOA_FISICA, encoder.encode("12222"));
        cliente1.addPerfil(Perfil.ADMIN);

        cliente.getTelefones().addAll(Arrays.asList("26262666", "51515ss"));
        cliente1.getTelefones().addAll(Arrays.asList("21231323", "22344664"));

        Endereco endereco = new Endereco(null, "Rua flores", "300", "Apto 300", "Jardim", "2324434", cliente, cidade);
        Endereco endereco1 = new Endereco(null, "Rua Matos", "212", "Apto 321", "Matão", "8678797", cliente, cidade1);
        Endereco endereco2 = new Endereco(null, "Rua Matos", "212", "Apto 321", "Matão", "8678797", cliente, cidade2);

        cliente.getEnderecos().addAll(Arrays.asList(endereco, endereco1));

        clienteRepository.saveAll(Arrays.asList(cliente));
        clienteRepository.saveAll(Arrays.asList(cliente1));
        enderecoRepository.saveAll(Arrays.asList(endereco, endereco1));
        enderecoRepository.saveAll(Arrays.asList(endereco, endereco1, endereco2));

        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy hh:mm");

        Pedido pedido = new Pedido(null, sdf.parse("30/09/2017 00:00"), cliente, endereco);
        Pedido pedido1 = new Pedido(null, sdf.parse("30/10/2018 00:00"), cliente, endereco1);

        Pagamento pagamento = new PagamentoComCartao(null, EstadoPagamento.QUITADO, pedido, 6);
        pedido.setPagamento(pagamento);

        Pagamento pagamento1 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, pedido1, sdf.parse("20/10/2017 00:00"), null);
        pedido1.setPagamento(pagamento1);

        cliente.getPedidos().addAll(Arrays.asList(pedido, pedido1));

        pedidoRepository.saveAll(Arrays.asList(pedido, pedido1));

        pagamentoRepository.saveAll(Arrays.asList(pagamento, pagamento1));

        ItemPedido itemPedido = new ItemPedido(pedido, p1, 0.0, 1, 2000.00);
        ItemPedido itemPedido1 = new ItemPedido(pedido, p3, 0.0, 2, 80.00);
        ItemPedido itemPedido2 = new ItemPedido(pedido1, p2, 100.0, 1, 800.00);

        pedido.getItens().addAll(Arrays.asList(itemPedido, itemPedido1));
        pedido.getItens().addAll(Arrays.asList(itemPedido2));

        p1.getItemPedido().addAll(Arrays.asList(itemPedido));
        p2.getItemPedido().addAll(Arrays.asList(itemPedido2));
        p3.getItemPedido().addAll(Arrays.asList(itemPedido1));

        itemPedidoRepository.saveAll(Arrays.asList(itemPedido, itemPedido1, itemPedido2));
    }
}
