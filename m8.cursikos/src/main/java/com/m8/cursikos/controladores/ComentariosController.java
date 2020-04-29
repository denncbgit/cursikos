package com.m8.cursikos.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.m8.cursikos.entities.Comentarios;
import com.m8.cursikos.repositorios.ComentarioRepositorio;

@Controller
public class ComentariosController {
	
	@Autowired
	ComentarioRepositorio comentarioRepositorio;
	
	@GetMapping("/saveComentario")
	public String saveComentario(@RequestParam("comentario") String texto, Model model) {
		if (texto!=null) {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			Comentarios comentario = new Comentarios();
			comentario.setComentario(texto);
			comentario.setUsuario_fk(authentication.getName());
			comentarioRepositorio.save(comentario);
			model.addAttribute("esBien", "Muchas gracias por tu comentario" + comentario.getUsuario_fk());
			return "esBien";
		}else {
			model.addAttribute("error", "Debe rellenar el campo de texto para ejecutar el envio");
			return "error";
		}
		
		
		
	}

}
