package com.m8.cursikos.controladores;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.Http2;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.m8.cursikos.entities.Usuario;
import com.m8.cursikos.repositorios.UsuarioRepositorio;



@Controller
public class RegistroControlador {
	
	@Autowired
	HttpSession session;
	//Usamos Autowired para no tener que crear una instancia del objeto en ningún caso dentro de esta clase
	@Autowired
	UsuarioRepositorio usuarioRepositorio;
	
	//Mostramos el form registro
	@GetMapping("/usuario/formRegistro")
	public String formRegistro(Model model , Usuario usuario ) {
		model.addAttribute("usuario", new Usuario());
		//model.addAttribute("usuarios", usuarioRepositorio.findAll());
		return "formRegistro";
	}
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
	    return bCryptPasswordEncoder;
	}
	
	
	@PostMapping("/usuario/registro")
	public String crearUsuario(@Valid  @ModelAttribute("usuario") Usuario usuario,BindingResult bindingResult, Model model) {
		//Comprobamos si el formulario contiene errores de validacion o si el email del usuario ya existe en la aplicacion
		if (usuarioRepositorio.findByUsername(usuario.getUsername()) != null) {
			model.addAttribute("error", "El usuario ya existe en la aplicacion");
			return "error";
		}
		if (bindingResult.hasErrors()) {
			return "formRegistro";
		}else {
			usuario.setEncPassword(bCryptPasswordEncoder.encode(usuario.getPassword()));
			usuario.setPassword("Uscyero12");
			usuarioRepositorio.save(usuario);
			model.addAttribute("esBien", "El usuario con email " + usuario.getEmail() + " y Username  " + usuario.getUsername());
			return "esBien";
		}
		
		
	}
	
	
	
	@GetMapping("/usuario/formLogin")
	public String formLogin(Model model , Usuario usuario) {
		return "formLogin";
	}
	
	
//	@PostMapping("/login")
//	public String login(@Valid  @ModelAttribute("usuario") Usuario usuario,BindingResult bindingResult, Model model, HttpServletRequest request, AuthenticationManagerBuilder auth) throws Exception { 
//		
//		if (bCryptPasswordEncoder.matches(usuario.getPassword(), usuarioRepositorio.findByEmail(usuario.getEmail()).getEncPassword())) {
//			session.setAttribute("usuario",usuarioRepositorio.findByEmail(usuario.getEmail()) );
//			
//		}
//		
//		return "index";
//	}
}