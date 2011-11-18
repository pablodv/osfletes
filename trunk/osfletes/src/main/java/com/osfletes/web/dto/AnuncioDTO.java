package com.osfletes.web.dto;

import java.util.Date;

public class AnuncioDTO {
	private Long id;
	private Date fechaDesde;
	private Date fechaHasta;
	private Date fechaCierre;
	private Integer horaDesde;
	private Integer horaHasta;
	private String direccionInicial;
	private String direccionFinal;
	
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
	public String getDireccionInicial() {
		return direccionInicial;
	}
	public void setDireccionInicial(String direccionInicial) {
		this.direccionInicial = direccionInicial;
	}
	public String getDireccionFinal() {
		return direccionFinal;
	}
	public void setDireccionFinal(String direccionFinal) {
		this.direccionFinal = direccionFinal;
	}
	
	
}
