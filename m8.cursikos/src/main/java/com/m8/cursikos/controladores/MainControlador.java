package com.m8.cursikos.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.m8.cursikos.entities.CompraCurso;
import com.m8.cursikos.repositorios.CursoRepositorio;

@Controller
public class MainControlador {
	
	@Autowired
	CursoRepositorio cursorepositorio;
	
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("cursos", cursorepositorio.findAll());
		model.addAttribute("compraCurso", new CompraCurso());
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		model.addAttribute("username", authentication.getName());

		return "fragmentos/index";
	}
	
	
}
