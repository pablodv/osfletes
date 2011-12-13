package com.osfletes.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Transient;

import com.osfletes.model.hibernate.ObjetoPersistente;
import com.osfletes.security.User;

@Entity
public class Oferta extends ObjetoPersistente {
	
	private static final long serialVersionUID = 915473460883012433L;

	@Transient
	private Anuncio anuncio;
	
	private Date fechaServicio;
	
	@Transient
	private User proveedor;
	
	private BigDecimal valorOferta;
	
	
	
	public Anuncio getAnuncio() {
		return anuncio;
	}
	public void setAnuncio(Anuncio anuncio) {
		this.anuncio = anuncio;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public Date getFechaServicio() {
		return fechaServicio;
	}
	public void setFechaServicio(Date fechaServicio) {
		this.fechaServicio = fechaServicio;
	}
	public User getProveedor() {
		return proveedor;
	}
	public void setProveedor(User proveedor) {
		this.proveedor = proveedor;
	}
	public BigDecimal getValorOferta() {
		return valorOferta;
	}
	public void setValorOferta(BigDecimal valorOferta) {
		this.valorOferta = valorOferta;
	}
	
	
}
