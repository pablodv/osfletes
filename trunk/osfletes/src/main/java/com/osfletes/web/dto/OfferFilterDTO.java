package com.osfletes.web.dto;

public class OfferFilterDTO extends GenericFilterDTO {

	private Long announcementId;
	private Integer estado; 

	public Long getAnnouncementId() {
		return announcementId;
	}

	public void setAnnouncementId(Long announcementId) {
		this.announcementId = announcementId;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}
	
	
}
