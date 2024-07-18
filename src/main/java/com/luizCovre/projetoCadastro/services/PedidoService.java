package com.luizCovre.projetoCadastro.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luizCovre.projetoCadastro.entities.Pedido;
import com.luizCovre.projetoCadastro.repositories.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repositorio;
	
	public List<Pedido> findAll(){
		return repositorio.findAll();
	}
	
	public Pedido findById(Long id) {
		Optional<Pedido> obj = repositorio.findById(id);
		return obj.get();
	}
}
