package com.m8.cursikos.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;


/**
 * Entidad que se encargara de formar el modelo de los comentarios de la aplicacion
 * @author Nerffren
 *
 */
@Entity
public class Comentarios {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotEmpty
	private String comentario;
	
	@NotEmpty
	private String usuario_fk;
	
	public Comentarios(){}


	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String getUsuario_fk() {
		return usuario_fk;
	}

	public void setUsuario_fk(String usuario_fk) {
		this.usuario_fk = usuario_fk;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comentario == null) ? 0 : comentario.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((usuario_fk == null) ? 0 : usuario_fk.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comentarios other = (Comentarios) obj;
		if (comentario == null) {
			if (other.comentario != null)
				return false;
		} else if (!comentario.equals(other.comentario))
			return false;
		if (id != other.id)
			return false;
		if (usuario_fk == null) {
			if (other.usuario_fk != null)
				return false;
		} else if (!usuario_fk.equals(other.usuario_fk))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Comentarios [id=" + id + ", comentario=" + comentario + ", usuario_fk=" + usuario_fk + "]";
	} 
	
	
	
	
}
