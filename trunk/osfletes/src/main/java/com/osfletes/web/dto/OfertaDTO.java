package com.osfletes.web.dto;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

public class OfertaDTO {
	@NumberFormat(style=Style.NUMBER)
	private BigDecimal value;
	private Long id;
	private Long announcementId;
	private Date serviceDate;
	
	
	
	public BigDecimal getValue() {
		return value;
	}
	public void setValue(BigDecimal valorOferta) {
		this.value = valorOferta;
	}
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getAnnouncementId() {
		return announcementId;
	}
	public void setAnnouncementId(Long anuncioId) {
		this.announcementId = anuncioId;
	}
	public Date getServiceDate() {
		return serviceDate;
	}
	public void setServiceDate(Date fechaServicio) {
		this.serviceDate = fechaServicio;
	}
	
	
	
	
}
