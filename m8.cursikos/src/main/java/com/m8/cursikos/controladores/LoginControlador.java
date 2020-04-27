//package com.m8.cursikos.controladores;
//
//import javax.validation.Valid;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import com.m8.cursikos.entities.Usuario;
//import com.m8.cursikos.repositorios.UsuarioRepositorio;
//
//@Controller
//public class LoginControlador {
//	
//	
//	@Autowired
//	UsuarioRepositorio usuarioRepositorio;
//	
//	@GetMapping("/usuario/formLogin")
//	public String formLogin(Model model , Usuario usuario) {
//		return "formLogin";
//	}
//	
//	
//	
//	
//	
//	@PostMapping("/usuario/login")
//	public String crearUsuario(@Valid  @ModelAttribute("usuario") Usuario usuario,BindingResult bindingResult, Model model) {
//		String password = usuario.getPassword();
//		
//		if(usuarioRepositorio.findByEmail(usuario.getEmail()) != null) {
//			model.addAttribute("esBien", "el email es correcto");
//			return "esBien";
//		}
//		model.addAttribute("error", "email erroneo");
//		return "error";
//		//Comprobamos si el formulario contiene errores de validacion o si el email del usuario ya existe en la aplicacion
//		if (usuarioRepositorio.findByEmail(usuario.getEmail()) != null) {
//			model.addAttribute("error", "El usuario ya existe en la aplicacion");
//			return "error";
//		}
//		if (bindingResult.hasErrors()) {
//			return "formRegistro";
//		}else {
//			usuario.setEncPassword(bCryptPasswordEncoder.encode(usuario.getPassword()));
//			usuario.setPassword("Uscyero12");
//			usuarioRepositorio.save(usuario);
//			model.addAttribute("esBien", "El usuario con email " + usuario.getEmail() + " y Username  " + usuario.getUsername());
//			return "esBien";
//		}
//	}
//}
