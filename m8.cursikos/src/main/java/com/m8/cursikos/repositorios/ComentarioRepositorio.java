package com.m8.cursikos.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.m8.cursikos.entities.Comentarios;

/**
 * Esta interfaz es en la que se crearan las consultas que necesitemos sobre la entidad Comentario 
 * con la extension de JPA
 * @author Nerffren
 *
 */
public interface ComentarioRepositorio extends JpaRepository<Comentarios, Long>{
	
}
