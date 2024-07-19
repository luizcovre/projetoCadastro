package com.luizCovre.projetoCadastro.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.luizCovre.projetoCadastro.entities.Categoria;
import com.luizCovre.projetoCadastro.entities.ItemPedido;
import com.luizCovre.projetoCadastro.entities.Pedido;
import com.luizCovre.projetoCadastro.entities.Produto;
import com.luizCovre.projetoCadastro.entities.Usuario;
import com.luizCovre.projetoCadastro.entities.enums.StatusPedido;
import com.luizCovre.projetoCadastro.repositories.CategoriaRepository;
import com.luizCovre.projetoCadastro.repositories.ItemPedidoRepository;
import com.luizCovre.projetoCadastro.repositories.PedidoRepository;
import com.luizCovre.projetoCadastro.repositories.ProdutoRepository;
import com.luizCovre.projetoCadastro.repositories.UsuarioRepository;

@Configuration
@Profile("teste")
public class TesteConfig implements CommandLineRunner {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;

	@Override
	public void run(String... args) throws Exception {
		Categoria categoria01 = new Categoria(null, "Informática");
		Categoria categoria02 = new Categoria(null, "Bazar");
		Categoria categoria03 = new Categoria(null, "Escritório");
		
		Produto produto01 = new Produto(null, "Notebook", "16Ram, SSD200GB", 3999.99, "/imagens/info");
		Produto produto02 = new Produto(null, "Fichario", "20 divisórias", 89.99, "/imagens/bazar");
		Produto produto03 = new Produto(null, "Cadeira", "regulagem de altura", 599.99, "/imagens/escritorio");
		Produto produto04 = new Produto(null, "Mouse", "sem fio", 99.99, "/imagens/info");
		Produto produto05 = new Produto(null, "Pacote sulfite", "200 folhas", 9.99, "/imagens/bazar");
		
		categoriaRepository.saveAll(Arrays.asList(categoria01, categoria02, categoria03));
		produtoRepository.saveAll(Arrays.asList(produto01, produto02, produto03, produto04, produto05));
		
		produto01.getCategorias().add(categoria01);
		produto01.getCategorias().add(categoria03);
		produto02.getCategorias().add(categoria02);
		produto03.getCategorias().add(categoria03);
		produto04.getCategorias().add(categoria01);
		produto05.getCategorias().add(categoria02);
		produto05.getCategorias().add(categoria03);
		
		produtoRepository.saveAll(Arrays.asList(produto01, produto02, produto03, produto04, produto05));
		
		Usuario usuario01 = new Usuario(null, "Luiz", "luiz.1covre@gmail.com", "999081085", "34154881876", "123456");
		Usuario usuario02 = new Usuario(null, "Covre", "covre@yahoo.com.br", "954982347", "34674855888", "123456");

		Pedido pedido01 = new Pedido(null, Instant.parse("2024-07-18T15:35:07Z"), StatusPedido.ENVIADO, usuario01);
		Pedido pedido02 = new Pedido(null, Instant.parse("2024-06-28T11:05:10Z"), StatusPedido.AGUARDANDO_PAGAMENTO, usuario02);
		Pedido pedido03 = new Pedido(null, Instant.parse("2024-06-28T12:45:22Z"), StatusPedido.AGUARDANDO_PAGAMENTO, usuario01);
		
		usuarioRepository.saveAll(Arrays.asList(usuario01, usuario02));
		pedidoRepository.saveAll(Arrays.asList(pedido01, pedido02, pedido03));
		
		ItemPedido ip01 = new ItemPedido(pedido01, produto01, 2, produto01.getPreco());
		ItemPedido ip02 = new ItemPedido(pedido01, produto03, 1, produto03.getPreco());
		ItemPedido ip03 = new ItemPedido(pedido02, produto03, 2, produto03.getPreco());
		ItemPedido ip04 = new ItemPedido(pedido03, produto05, 2, produto05.getPreco());
		
		itemPedidoRepository.saveAll(Arrays.asList(ip01, ip02, ip03, ip04));
	}
}
