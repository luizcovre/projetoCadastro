package com.luizCovre.projetoCadastro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.luizCovre.projetoCadastro.entities.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
