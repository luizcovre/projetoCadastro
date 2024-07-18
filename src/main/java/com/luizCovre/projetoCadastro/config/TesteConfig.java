package com.luizCovre.projetoCadastro.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.luizCovre.projetoCadastro.entities.Usuario;
import com.luizCovre.projetoCadastro.repositories.UsuarioRepository;

@Configuration
@Profile("teste")
public class TesteConfig implements CommandLineRunner {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public void run(String... args) throws Exception {
		Usuario usuario01 = new Usuario(null, "Luiz", "luiz.1covre@gmail.com", "999081085", "34154881876", "123456");
		Usuario usuario02 = new Usuario(null, "Covre", "covre@yahoo.com.br", "954982347", "34674855888", "123456");
		Usuario usuario03 = new Usuario(null, "Camila", "cami_lourenco@gmail.com", "912345678", "01122334455", "123456");
		Usuario usuario04 = new Usuario(null, "Lorena", "lore_covre@gmail.com", "987654321", "16677889900", "123456");

		usuarioRepository.saveAll(Arrays.asList(usuario01, usuario02, usuario03, usuario04));
	}
}
