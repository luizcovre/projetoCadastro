package com.luizCovre.projetoCadastro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.luizCovre.projetoCadastro.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
