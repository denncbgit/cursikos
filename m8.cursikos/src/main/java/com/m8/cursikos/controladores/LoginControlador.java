package com.m8.cursikos.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.m8.cursikos.entities.Usuario;

/**
 * controlador encargado de mostra el formulario de login
 * @author Nerffren
 *
 */
@Controller
public class LoginControlador {

	/**
	 * este metodo nos devuelve el formulario de login
	 * @param model
	 * @param usuario
	 * @return
	 */
	@GetMapping("/formLogin")
	public String formLogin(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "formLogin";
	}
}
