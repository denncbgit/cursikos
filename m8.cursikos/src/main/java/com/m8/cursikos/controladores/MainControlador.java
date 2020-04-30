package com.m8.cursikos.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.m8.cursikos.entities.Comentarios;
import com.m8.cursikos.entities.CompraCurso;
import com.m8.cursikos.repositorios.CursoRepositorio;


/**
 * Controlador que nos lleva a la pagina de inicio
 * @author Nerffren
 *
 */
@Controller
public class MainControlador {
	
	
	/**
	 * autocableado de la interfaz curso repositorios
	 */
	@Autowired
	CursoRepositorio cursorepositorio;
	
	
	/**
	 * le pasa a la vista de la home los parametros necesariuos para rellenar los formularios
	 * @param model
	 * @return
	 */
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("cursos", cursorepositorio.findAll());
		model.addAttribute("compraCurso", new CompraCurso());
		model.addAttribute("comentario", new Comentarios());
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		model.addAttribute("username", authentication.getName());

		return "fragmentos/index";
	}
	
	
}
