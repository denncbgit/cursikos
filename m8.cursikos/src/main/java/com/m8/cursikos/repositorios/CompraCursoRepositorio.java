package com.m8.cursikos.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.m8.cursikos.entities.CompraCurso;


/**
 * Esta interfaz es en la que se crearan las consultas que necesitemos sobre la entidad que 
 * relaciona las compras de los cursos con los usuarios con la extension de JPA
 * 
 * @author Nerffren
 *
 */
public interface CompraCursoRepositorio extends JpaRepository<CompraCurso, Long>{

}
