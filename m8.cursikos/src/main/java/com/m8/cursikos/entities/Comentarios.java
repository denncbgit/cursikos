package com.m8.cursikos.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class Comentarios {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotEmpty
	private long usuario_fk; 
	
	private long curso_fk;
	
	@NotEmpty
	private String Comentario;
	
	public Comentarios(){}

	public Comentarios(@NotEmpty long usuario_fk, long curso_fk, @NotEmpty String comentario) {
		super();
		this.usuario_fk = usuario_fk;
		this.curso_fk = curso_fk;
		Comentario = comentario;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getUsuario_fk() {
		return usuario_fk;
	}

	public void setUsuario_fk(long usuario_fk) {
		this.usuario_fk = usuario_fk;
	}

	public long getCurso_fk() {
		return curso_fk;
	}

	public void setCurso_fk(long curso_fk) {
		this.curso_fk = curso_fk;
	}

	public String getComentario() {
		return Comentario;
	}

	public void setComentario(String comentario) {
		Comentario = comentario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Comentario == null) ? 0 : Comentario.hashCode());
		result = prime * result + (int) (curso_fk ^ (curso_fk >>> 32));
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + (int) (usuario_fk ^ (usuario_fk >>> 32));
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
		if (Comentario == null) {
			if (other.Comentario != null)
				return false;
		} else if (!Comentario.equals(other.Comentario))
			return false;
		if (curso_fk != other.curso_fk)
			return false;
		if (id != other.id)
			return false;
		if (usuario_fk != other.usuario_fk)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Comentarios [id=" + id + ", usuario_fk=" + usuario_fk + ", curso_fk=" + curso_fk + ", Comentario="
				+ Comentario + "]";
	}
	
	
	
}
