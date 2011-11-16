package com.osfletes.web.dto;

import java.util.Date;

import com.osfletes.model.User;

public class AnuncioMultipleDTO {

	public Long id;
	public Date fechaDesde;
	public Date fechaHasta;
	public Date fechaCreacion;
	public Date fechaCierre;
	public Integer horaDesde;
	public Integer horaHasta;
    //public User user;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	
	
}
