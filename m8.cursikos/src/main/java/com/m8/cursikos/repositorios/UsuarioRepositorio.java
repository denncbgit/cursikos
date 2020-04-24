package com.m8.cursikos.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.m8.cursikos.entities.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {
	Usuario findByEmail(String email);
	Usuario findByUsername(String username);
	List<Usuario> findAll();
}
