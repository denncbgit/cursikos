package com.m8.cursikos.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.m8.cursikos.entities.Comentarios;
import com.m8.cursikos.repositorios.ComentarioRepositorio;

@Controller
public class ComentariosController {
	
	@Autowired
	ComentarioRepositorio comentarioRepositorio;
	
	@GetMapping("saveComentario")
	public String saveComentario(Comentarios comentario) {
		comentarioRepositorio.save(comentario);
		return "esBien";
	}

}
