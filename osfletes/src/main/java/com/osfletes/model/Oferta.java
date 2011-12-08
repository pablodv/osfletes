package com.osfletes.model;

import java.math.BigDecimal;
import java.util.Date;

import siena.Column;
import siena.Id;
import siena.Model;


public class Oferta extends Model{

	@Id
	private Long id;
	@Column("anuncio_id")
	private Anuncio anuncio;
	@Column("fecha_creacion")
	private Date fechaCreacion;
	@Column("fecha_servicio")
	private Date fechaServicio;
	@Column("proveedor_id")
	private User proveedor;
	@Column("valor_oferta")
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
