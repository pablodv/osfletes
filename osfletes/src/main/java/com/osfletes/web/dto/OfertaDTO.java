package com.osfletes.web.dto;

import java.math.BigDecimal;

public class OfertaDTO {
	private BigDecimal valorOferta;
	private Long id;
	
	
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
	
	
}
