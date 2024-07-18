package com.luizCovre.projetoCadastro.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.luizCovre.projetoCadastro.entities.Categoria;
import com.luizCovre.projetoCadastro.entities.Pedido;
import com.luizCovre.projetoCadastro.entities.Usuario;
import com.luizCovre.projetoCadastro.entities.enums.StatusPedido;
import com.luizCovre.projetoCadastro.repositories.CategoriaRepository;
import com.luizCovre.projetoCadastro.repositories.PedidoRepository;
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

	@Override
	public void run(String... args) throws Exception {
		Categoria categoria01 = new Categoria(null, "Informática");
		Categoria categoria02 = new Categoria(null, "Bazar");
		Categoria categoria03 = new Categoria(null, "Escritório");
		
		categoriaRepository.saveAll(Arrays.asList(categoria01, categoria02, categoria03));
		
		Usuario usuario01 = new Usuario(null, "Luiz", "luiz.1covre@gmail.com", "999081085", "34154881876", "123456");
		Usuario usuario02 = new Usuario(null, "Covre", "covre@yahoo.com.br", "954982347", "34674855888", "123456");

		Pedido pedido01 = new Pedido(null, Instant.parse("2024-07-18T15:35:07Z"), StatusPedido.ENVIADO, usuario01);
		Pedido pedido02 = new Pedido(null, Instant.parse("2024-06-28T11:05:10Z"), StatusPedido.AGUARDANDO_PAGAMENTO, usuario02);
		Pedido pedido03 = new Pedido(null, Instant.parse("2024-06-28T12:45:22Z"), StatusPedido.AGUARDANDO_PAGAMENTO, usuario01);
		
		usuarioRepository.saveAll(Arrays.asList(usuario01, usuario02));
		pedidoRepository.saveAll(Arrays.asList(pedido01, pedido02, pedido03));
	}
}
