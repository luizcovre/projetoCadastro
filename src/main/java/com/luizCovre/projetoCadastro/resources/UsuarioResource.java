package com.luizCovre.projetoCadastro.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.luizCovre.projetoCadastro.entities.Usuario;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {

	@GetMapping
	public ResponseEntity<Usuario> findAll(){
		Usuario usuario = new Usuario(1L, "Luiz", "luiz.1covre@gmail.com", "(47) 999081085", "341.548.818.76", "12345");
		return ResponseEntity.ok().body(usuario);
	}
}
