package com.osfletes.model;

import java.math.BigDecimal;
import java.util.Date;

import com.osfletes.security.User;


public class Oferta {

	
	private Long id;
	
	private Anuncio anuncio;
	
	private Date fechaCreacion;
	
	private Date fechaServicio;
	
	private User proveedor;
	
	private BigDecimal valorOferta;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
