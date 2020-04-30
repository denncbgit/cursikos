package com.m8.cursikos.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;


/**
 * Entidad encargada de definir el modelo de usuarios
 * @author Nerffren
 *
 */
@Entity
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	
	@Pattern(regexp = "^[A-Za-z0-9_-]{2,16}$", message ="El nombre de Usuario debe tener como minimo 2 letras y como maximo 16 y solo debe contener (mayusculas, minusculas, numeros, '-' y '_')")
	@NotEmpty
	private String username;
	
	
	@Email
	@Pattern(regexp = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$", message = "La sintaxis del email es incorrecta")
	@NotEmpty
	private String email;
	
	@Pattern(regexp = "(?=\\w*\\d)(?=\\w*[A-Z])(?=\\w*[a-z])\\S{8,16}$", message = "Recuerde que debe tener 8 caracteres y almenos, un digito, una letra mayus y minus y un simbolo" )
	@NotEmpty
	private String password;
	
	private String EncPassword;
	public Usuario() {}
	
	
	
	
	public Usuario(String username,String email,String password) {
		this.username = username;
		this.email = email;
		this.password = password;
	}
	
	public Usuario(String username,String email,String password, boolean bool) {
		this.username = username;
		this.email = email;
		this.EncPassword = password;
		this.password = "Uscyero12";
	}




	public long getId() {
		return id;
	}




	public void setId(long id) {
		this.id = id;
	}




	public String getUsername() {
		return username;
	}




	public void setUsername(String username) {
		this.username = username;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public String getEncPassword() {
		return EncPassword;
	}




	public void setEncPassword(String encPassword) {
		EncPassword = encPassword;
	}



	




	@Override
	public String toString() {
		return "Usuario [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", EncPassword=" + EncPassword + "]";
	}



	
	
	
	
	
}
