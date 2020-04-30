package com.m8.cursikos.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.m8.cursikos.entities.Usuario;


/**
 * Esta interfaz es en la que se crearan las consultas que necesitemos sobre la entidad Usuario 
 * con la extension de JPA
 * @author Nerffren
 *
 */
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {
	Usuario findByEmail(String email);
	Usuario findByUsername(String username);
	List<Usuario> findAll();
}
