package com.m8.cursikos.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.m8.cursikos.entities.CompraCurso;
import com.m8.cursikos.entities.Curso;
import com.m8.cursikos.entities.Usuario;
import com.m8.cursikos.repositorios.CursoRepositorio;
import com.m8.cursikos.repositorios.UsuarioRepositorio;


/**
 * Esta clase se encarga de insertar ciertos objetos en la base de datos a la hora de iniciar la aplicacion
 * @author Nerffren
 *
 */
@Component
public class MyRunner implements CommandLineRunner {
	
	
	@Autowired
	UsuarioRepositorio usuarioRepositorio;
	
	@Autowired
	CursoRepositorio cursoRepositorio;
    @Override
    public void run(String... args) throws Exception {
    	Usuario user = new Usuario("Nerffren", "dennis@gmail.com", "$2a$10$F7mkpSWhnyntpjKYcVTfEOj3TKsvvj6TxAebbggyrZL7Rt88En8FW", true);
    	
    	
    	Curso curso1 = new Curso("Curso maestro pokémon",
    			"https://pbs.twimg.com/media/EDF2UI1XoAAnzd2.jpg",
    			"¿Como hacerte con todos?, inscribite para saberlo",
    			20);
    	
    	Curso curso2 = new Curso("Curso Magia y hechiceria fuera de Howards",
    			"https://pbs.twimg.com/media/EDF2UI1XoAAnzd2.jpg",
    			"como puedes levantar una pluma sin tocarla y mucho más",
    			15);
    	
    	Curso curso3 = new Curso("tecnicas Saiyayin 101",
    			"https://pbs.twimg.com/media/EDF2UI1XoAAnzd2.jpg",
    			"CANOOOO... DE GAAAALICK!",
    			25);
    	try {
    		usuarioRepositorio.save(user);
	    	cursoRepositorio.save(curso1);
	    	cursoRepositorio.save(curso2);
	    	cursoRepositorio.save(curso3);
		} catch (Exception e) {
			e.notify();
		}
	    	
    }
}