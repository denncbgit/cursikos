//package com.m8.cursikos.testEntidades;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.m8.cursikos.entities.Usuario;
//import com.m8.cursikos.repositorios.UsuarioRepositorio;
//
///**
// * test sobre la entidad usuario y sus inserciones en la BD de la clase Usuario
// * @author Nerffren
// *
// */
//@RunWith(SpringRunner.class)
//@DataJpaTest
//public class testUsuarioEntidad {
//	
//	@Autowired
//	TestEntityManager entityManager;
//	
//	@Autowired
//	UsuarioRepositorio usuarioRepositorio;
//	
//	@Test
//	 public void busquedaUsuarioByUsername() {
//		String username = "Nerffren";
//		Usuario usuario = new Usuario("Nerffren", "nerffren@gmail.com", "Pjuegko12");
//		usuarioRepositorio.save(usuario);
//	    Usuario found = usuarioRepositorio.findByUsername(username);
//	    
//	    assertThat(found.getUsername())
//	      .isEqualTo(username);
//	 }
//	
//
//}
