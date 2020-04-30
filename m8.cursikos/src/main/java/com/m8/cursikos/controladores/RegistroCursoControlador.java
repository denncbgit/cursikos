package com.m8.cursikos.controladores;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import com.m8.cursikos.entities.CompraCurso;
import com.m8.cursikos.entities.Curso;
import com.m8.cursikos.repositorios.CompraCursoRepositorio;
import com.m8.cursikos.repositorios.CursoRepositorio;

/**
 * Este controlador recibe la peticion del formulario de registro de curso y se encarga
 * de comprobar los datos y insertarlos en la BBDD
 * @author Nerffren
 *
 */
@Controller
public class RegistroCursoControlador {
	
	/**
	 * Autocableamos los repositorios que utilizaremos en esta clase 
	 * para hacer peticiones a la BBDD
	 */
	@Autowired
	CompraCursoRepositorio compraCursoRepositorio;
	
	@Autowired
	CursoRepositorio cursoRepositorio;
	
	
	/**
	 * Comprobamos los datos del formulario y devolvemos un feedhback al usuaro
	 * , del proceso
	 * @param compraCurso
	 * @param model
	 * @return
	 */
	@PostMapping("/registroCurso")
	public String registroCurso(CompraCurso compraCurso, Model model) {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if (compraCurso.getMetodoPago() == null || compraCurso.getValoracion()<=0 || compraCurso.getProductos() == null) {
			model.addAttribute("error", "Faltan campos por rellenar");
			return "error";
		}
		String[] listaIdCursos = compraCurso.getProductos().split(",");
		String cursos = "";
		int precioTotal=0;
		for (String idCurso : listaIdCursos) {
			cursos += " ,";
			Curso curso = cursoRepositorio.findById(Long.parseLong(idCurso));
			cursos += curso.getNombre() ;
			precioTotal = precioTotal + curso.getPrecio();
		}
		
		CompraCurso cc = new CompraCurso();
		cc.setMetodoPago(compraCurso.getMetodoPago());
		cc.setValoracion(compraCurso.getValoracion());
		cc.setUsernameFk(authentication.getName());
		cc.setAmount(precioTotal);
		cc.setProductos(cursos.substring(2, cursos.length()));
		model.addAttribute("esBien", cc.getUsernameFk() + " se ha registrado en los cursos " + 
		cursos + " por el modico precio de " + cc.getAmount() + "€ el metodo de pago ha sido " + cc.getMetodoPago() );
		
		cursoRepositorio.save(cc);
		return "esBien";

		
	}
}
