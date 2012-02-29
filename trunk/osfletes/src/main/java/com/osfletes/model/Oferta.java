package com.osfletes.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.licitaciones.StateAware;
import com.osfletes.model.hibernate.ObjetoPersistente;

@Entity(name="OFERTA")
public class Oferta extends ObjetoPersistente implements StateAware {
	
	private static final long serialVersionUID = 915473460883012433L;

	@ManyToOne
	@JoinColumn(name="ANUNCIO_ID")
	private Anuncio anuncio;
	
	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_SERVICIO")
	private Date fechaServicio;
	
	@Column(name="VALOR_OFERTA")
	private BigDecimal valorOferta;
	
	@Column(name="ESTADO")
	private int state;
	
	
	public Date getFechaServicio() {
		return fechaServicio;
	}
	public void setFechaServicio(Date fechaServicio) {
		this.fechaServicio = fechaServicio;
	}
	
	public BigDecimal getValorOferta() {
		return valorOferta;
	}
	public void setValorOferta(BigDecimal valorOferta) {
		this.valorOferta = valorOferta;
	}
	public Anuncio getAnuncio() {
		return anuncio;
	}
	public void setAnuncio(Anuncio anuncio) {
		this.anuncio = anuncio;
	}

	@Override
	public void setState(int stateId) {
		this.state = stateId;
	}
	@Override
	public int getState() {
		return this.state;
	}
	
	
	
}
