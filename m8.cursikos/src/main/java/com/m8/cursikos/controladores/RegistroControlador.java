package com.m8.cursikos.controladores;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.m8.cursikos.entities.Usuario;
import com.m8.cursikos.repositorios.UsuarioRepositorio;


/**
 * Controlador que se encarga de 
 * @author Nerffren
 *
 */
@Controller
public class RegistroControlador {
	
	/**
	 * Usamos Autowired para no tener que crear una instancia del objeto en ningún caso dentro de esta clase
	 */
	@Autowired
	UsuarioRepositorio usuarioRepositorio;
	
	/**
	 * Mostramos el form registro
	 * @param model
	 * @param usuario
	 * @return
	 */
	@GetMapping("/usuario/formRegistro")
	public String formRegistro(Model model , Usuario usuario ) {
		model.addAttribute("usuario", new Usuario());
		model.addAttribute("usuarios", usuarioRepositorio.findAll());
		return "formRegistro";
	}
	
	/**
	 * autocableamos la clase que nos permitira encriptar la contraseña en el registro
	 */
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
	    return bCryptPasswordEncoder;
	}
	
	/**
	 * clase que recibe el usuario del formulario de registro y se encarga de guardarlo en la BBDD
	 * @param usuario
	 * @param bindingResult
	 * @param model
	 * @return
	 */
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
	public String formLogin(Model model , Usuario usuario ) {
		return "formLogin";
		
	}

}
