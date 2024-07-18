package com.luizCovre.projetoCadastro.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luizCovre.projetoCadastro.entities.Categoria;
import com.luizCovre.projetoCadastro.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repositorio;
	
	public List<Categoria> findAll(){
		return repositorio.findAll();
	}
	
	public Categoria findById(Long id) {
		Optional<Categoria> obj = repositorio.findById(id);
		return obj.get();
	}
}
