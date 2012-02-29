package com.osfletes.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.licitaciones.StateAware;
import com.osfletes.model.hibernate.ObjetoPersistente;


@Entity(name="ANUNCIO")
@Inheritance(strategy=InheritanceType.JOINED)
public class Anuncio extends ObjetoPersistente implements StateAware{
	
	private static final long serialVersionUID = -1960041916990966080L;

	@Temporal(TemporalType.DATE)
    @Column(name="FECHA_DESDE")
	public Date fechaDesde;
	@Temporal(TemporalType.DATE)
    @Column(name="FECHA_HASTA")
	public Date fechaHasta;
	@Temporal(TemporalType.DATE)
    @Column(name="FECHA_CIERRE")
	public Date fechaCierre;
    @Column(name="HORA_DESDE")
    public Integer horaDesde;
    @Column(name="HORA_HASTA")
    public Integer horaHasta;
    @Column(name="DESCRIPCION")
    public String descripcion;
    
   
    @Column(name="ESTADO")
    public int estado;
   

	public Date getFechaDesde() {
		return fechaDesde;
	}

	public void setFechaDesde(Date fechaDesde) {
		this.fechaDesde = fechaDesde;
	}

	public Date getFechaHasta() {
		return fechaHasta;
	}

	public void setFechaHasta(Date fechaHasta) {
		this.fechaHasta = fechaHasta;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaCierre() {
		return fechaCierre;
	}

	public void setFechaCierre(Date fechaCierre) {
		this.fechaCierre = fechaCierre;
	}

	public Integer getHoraDesde() {
		return horaDesde;
	}

	public void setHoraDesde(Integer horaDesde) {
		this.horaDesde = horaDesde;
	}

	public Integer getHoraHasta() {
		return horaHasta;
	}

	public void setHoraHasta(Integer horaHasta) {
		this.horaHasta = horaHasta;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	public void setState(int estado) {
		this.estado = estado;
	}

	@Override
	public int getState() {
		return this.estado;
	}
    
	
	
}
