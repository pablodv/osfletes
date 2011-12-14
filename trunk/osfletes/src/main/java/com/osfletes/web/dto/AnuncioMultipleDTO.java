package com.osfletes.web.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AnuncioMultipleDTO {

	public Long id;
	public Date fechaDesde;
	public Date fechaHasta;
	public Date fechaCreacion;
	public Date fechaCierre;
	public Integer horaDesde;
	public Integer horaHasta;
	private String direccion1;
	private String direccion2;
	private String descripcion;
	
	private List<DireccionDTO> listaDireccionesDTO;
	
    //public User user;
	
	
	public Date getFechaDesde() {
		return fechaDesde;
	}
	
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
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
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public List<DireccionDTO> getListaDireccionesDTO() {
		if(this.listaDireccionesDTO==null){
			this.listaDireccionesDTO = new ArrayList<DireccionDTO>();
		}
		return listaDireccionesDTO;
	}
	public void setListaDireccionesDTO(List<DireccionDTO> listaDireccionesDTO) {
		this.listaDireccionesDTO = listaDireccionesDTO;
	}
}
