package com.luizCovre.projetoCadastro.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.luizCovre.projetoCadastro.entities.Usuario;
import com.luizCovre.projetoCadastro.repositories.UsuarioRepository;
import com.luizCovre.projetoCadastro.services.exceptions.ResourceNotFoundException;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repositorio;
	
	public List<Usuario> findAll(){
		return repositorio.findAll();
	}
	
	public Usuario findById(Long id) {
		Optional<Usuario> obj = repositorio.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Usuario insert(Usuario usuario) {
		return repositorio.save(usuario);
	}
	
	public void delete(Long id) {
		repositorio.deleteById(id);
	}
	
	public Usuario update(Long id, Usuario obj) {
		Usuario usuario = repositorio.getReferenceById(id);
		updateDados(usuario, obj);
		return repositorio.save(usuario);
	}
	
	private void updateDados(Usuario usuario, Usuario obj) {
		usuario.setNome(obj.getNome());
		usuario.setEmail(obj.getEmail());
		usuario.setCelular(obj.getCelular());
		usuario.setCpf(obj.getCpf());
	}
	
}
