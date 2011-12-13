package com.osfletes.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.osfletes.model.hibernate.ObjetoPersistente;

@Entity(name="DIRECCION")
public class Direccion extends ObjetoPersistente {
    	
	private static final long serialVersionUID = -7655302342651941565L;

	@Column(name="DIRECCION")
	public String direccion;
    @Column(name="LONGITUD")
	public BigDecimal longitud;
    @Column(name="LATITUD")
	public BigDecimal latitud;
    @Column(name="POSICION")
    public Integer posicion;
    
    
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public BigDecimal getLongitud() {
		return longitud;
	}
	public void setLongitud(BigDecimal longitud) {
		this.longitud = longitud;
	}
	public BigDecimal getLatitud() {
		return latitud;
	}
	public void setLatitud(BigDecimal latitud) {
		this.latitud = latitud;
	}
	public Integer getPosicion() {
		return posicion;
	}
	public void setPosicion(Integer posicion) {
		this.posicion = posicion;
	}
}
