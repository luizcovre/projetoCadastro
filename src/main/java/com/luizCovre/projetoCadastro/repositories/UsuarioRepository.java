package com.luizCovre.projetoCadastro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.luizCovre.projetoCadastro.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
