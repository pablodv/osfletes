package com.osfletes.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.osfletes.model.hibernate.ObjetoPersistente;
import com.osfletes.security.User;

@Entity
public class Oferta extends ObjetoPersistente {
	
	private static final long serialVersionUID = 915473460883012433L;

	@ManyToOne
	private AnuncioMultipleLocalizado anuncio;
	
	private Date fechaServicio;
	
	@ManyToOne
	private User proveedor;
	
	@Column(name="VALOR_OFERTA")
	private BigDecimal valorOferta;
	
	@Column(name="VENCIDA")
	private Boolean vencida = false;
	
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
	public AnuncioMultipleLocalizado getAnuncio() {
		return anuncio;
	}
	public void setAnuncio(AnuncioMultipleLocalizado anuncio) {
		this.anuncio = anuncio;
	}
	public Boolean getVencida() {
		return vencida;
	}
	public void setVencida(Boolean vencida) {
		this.vencida = vencida;
	}
	
	
}
