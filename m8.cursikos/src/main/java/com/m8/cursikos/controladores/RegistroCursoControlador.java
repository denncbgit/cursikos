package com.m8.cursikos.controladores;

import java.util.Optional;

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

@Controller
public class RegistroCursoControlador {
	
	@Autowired
	CompraCursoRepositorio compraCursoRepositorio;
	
	@Autowired
	CursoRepositorio cursoRepositorio;
	
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
