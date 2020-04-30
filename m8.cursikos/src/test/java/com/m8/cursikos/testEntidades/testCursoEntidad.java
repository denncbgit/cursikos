package com.m8.cursikos.testEntidades;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.function.IntPredicate;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.m8.cursikos.entities.Curso;
import com.m8.cursikos.repositorios.CursoRepositorio;


/**
 * test sobre la entidad usuario y sus inserciones en la BD de la clase Entidad
 * @author Nerffren
 *
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class testCursoEntidad {
	
	@Autowired
	TestEntityManager entityManager;
	
	@Autowired
	CursoRepositorio cursoRepositorio;
	
	
	
	@Test
	public void insertCurso() {
		Curso curso = new Curso("cursako to guapo", " imagen flama" ,  "el curso esta to flama", 23);
		assertThat(curso).isNotNull();
	}
	
	@Test
	public void obtenerCursoPorId() {
		Curso curso = new Curso("cursako to guapo", " imagen flama" ,  "el curso esta to flama", 23);
		cursoRepositorio.save(curso);
		assertThat(curso.getNombre()).isEqualTo(cursoRepositorio.findById(1l).getNombre());
	}
}
