package com.m8.cursikos.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.sun.istack.NotNull;

@Entity
public class CompraCurso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotNull
	private String usernameFk;
	
	@NotNull
	private String productos;
	
	@NotNull
	private String metodoPago;
	
	@NotNull
	private int valoracion;
	
	
	private int amount;
	
	
	public CompraCurso() {
		super();
	}


	public CompraCurso(long id, String usernameFk, String productos, String metodoPago, int valoracion, int amount) {
		super();
		this.id = id;
		this.usernameFk = usernameFk;
		this.productos = productos;
		this.metodoPago = metodoPago;
		this.valoracion = valoracion;
		this.amount = amount;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getUsernameFk() {
		return usernameFk;
	}


	public void setUsernameFk(String usernameFk) {
		this.usernameFk = usernameFk;
	}


	public String getProductos() {
		return productos;
	}


	public void setProductos(String productos) {
		this.productos = productos;
	}


	public String getMetodoPago() {
		return metodoPago;
	}


	public void setMetodoPago(String metodoPago) {
		this.metodoPago = metodoPago;
	}


	public int getValoracion() {
		return valoracion;
	}


	public void setValoracion(int valoracion) {
		this.valoracion = valoracion;
	}


	public int getAmount() {
		return amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}


	


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + amount;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((metodoPago == null) ? 0 : metodoPago.hashCode());
		result = prime * result + ((productos == null) ? 0 : productos.hashCode());
		result = prime * result + ((usernameFk == null) ? 0 : usernameFk.hashCode());
		result = prime * result + valoracion;
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
		CompraCurso other = (CompraCurso) obj;
		if (amount != other.amount)
			return false;
		if (id != other.id)
			return false;
		if (metodoPago == null) {
			if (other.metodoPago != null)
				return false;
		} else if (!metodoPago.equals(other.metodoPago))
			return false;
		if (productos == null) {
			if (other.productos != null)
				return false;
		} else if (!productos.equals(other.productos))
			return false;
		if (usernameFk == null) {
			if (other.usernameFk != null)
				return false;
		} else if (!usernameFk.equals(other.usernameFk))
			return false;
		if (valoracion != other.valoracion)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "CompraCurso [id=" + id + ", usernameFk=" + usernameFk + ", productos=" + productos + ", metodoPago="
				+ metodoPago + ", valoracion=" + valoracion + ", amount=" + amount + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
