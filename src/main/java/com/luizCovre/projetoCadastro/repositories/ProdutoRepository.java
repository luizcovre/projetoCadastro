package com.luizCovre.projetoCadastro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.luizCovre.projetoCadastro.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
