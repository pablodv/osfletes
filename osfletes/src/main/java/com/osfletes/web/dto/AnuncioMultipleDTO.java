package com.osfletes.web.dto;

import java.util.Date;
import com.osfletes.web.dto.DireccionDTO;

public class AnuncioMultipleDTO {

	public Long id;
	public Date fechaDesde;
	public Date fechaHasta;
	public Date fechaCreacion;
	public Date fechaCierre;
	public Integer horaDesde;
	public Integer horaHasta;
	//public DireccionDTO direccionDTO1 = new DireccionDTO();
	//public DireccionDTO direccionDTO2 = new DireccionDTO(); 
	private String direccion1;
	private String direccion2;
	
	
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
	/*
	public String getDireccionDTO1() {
		return direccionDTO1.getDireccion();
	}
	public void setDireccionDTO1(String direccionDTO1) {
		this.direccionDTO1.setDireccion(direccionDTO1);
	}
	public DireccionDTO getDireccionDTO2() {
		return direccionDTO2;
	}
	public void setDireccionDTO2(DireccionDTO direccionDTO2) {
		this.direccionDTO2 = direccionDTO2;
	}
	*/
	public String getDireccion1() {
		return direccion1;
	}
	public void setDireccion1(String direccion1) {
		this.direccion1 = direccion1;
	}
	public String getDireccion2() {
		return direccion2;
	}
	public void setDireccion2(String direccion2) {
		this.direccion2 = direccion2;
	}
	
	
}
