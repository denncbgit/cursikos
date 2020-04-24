package com.m8.cursikos.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

public class Curso {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idd;
	
	@NotEmpty
	private String nombre;
	
	@NotEmpty
	private String image;
	
	@NotEmpty
	private String metodoDePago;
	
	public Curso () {}

	public Curso(String nombre, String image, String metodoDePago) {
		super();
		this.nombre = nombre;
		this.image = image;
		this.metodoDePago = metodoDePago;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getMetodoDePago() {
		return metodoDePago;
	}

	public void setMetodoDePago(String metodoDePago) {
		this.metodoDePago = metodoDePago;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + ((metodoDePago == null) ? 0 : metodoDePago.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		Curso other = (Curso) obj;
		if (id != other.id)
			return false;
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		if (metodoDePago == null) {
			if (other.metodoDePago != null)
				return false;
		} else if (!metodoDePago.equals(other.metodoDePago))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Curso [id=" + id + ", nombre=" + nombre + ", image=" + image + ", metodoDePago=" + metodoDePago + "]";
	}
	
	
	
	
}
