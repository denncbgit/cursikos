package com.m8.cursikos.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.m8.cursikos.entities.Comentarios;

public interface ComentarioRepositorio extends JpaRepository<Comentarios, Long>{
	
}
