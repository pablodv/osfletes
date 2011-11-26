package com.osfletes.web.dto;

import java.math.BigDecimal;

public class OfertaDTO {
//	@NumberFormat(style=Style.CURRENCY)
	private BigDecimal valorOferta;
	private Long id;
	private Long anuncioId;
//	@DateTimeFormat(iso=ISO.DATE)
//	private Date fechaServicio;
	
	
	
	public BigDecimal getValorOferta() {
		return valorOferta;
	}
	public void setValorOferta(BigDecimal valorOferta) {
		this.valorOferta = valorOferta;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getAnuncioId() {
		return anuncioId;
	}
	public void setAnuncioId(Long anuncioId) {
		this.anuncioId = anuncioId;
	}
//	public Date getFechaServicio() {
//		return fechaServicio;
//	}
//	public void setFechaServicio(Date fechaServicio) {
//		this.fechaServicio = fechaServicio;
//	}
	
	
	
	
}
