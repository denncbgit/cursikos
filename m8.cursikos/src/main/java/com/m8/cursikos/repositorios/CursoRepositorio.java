package com.m8.cursikos.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.m8.cursikos.entities.CompraCurso;
import com.m8.cursikos.entities.Curso;

/**
 * Esta interfaz es en la que se crearan las consultas que necesitemos sobre la entidad Curso 
 * con la extension de JPA
 * @author Nerffren
 *
 */
public interface CursoRepositorio extends  JpaRepository<Curso, Long>{
		Curso findById(long id);
		List<Curso> findAll();
		void save(CompraCurso cc);
}
