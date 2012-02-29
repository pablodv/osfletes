package com.osfletes.web.dto;

public class ContractDTO<T extends AnuncioDTO> {
	private T announcementDTO = null;
	private OfertaDTO offerDTO = null;
	
	
	
	public T getAnnouncementDTO() {
		return announcementDTO;
	}
	public void setAnnouncementDTO(T announcementDTO) {
		this.announcementDTO = announcementDTO;
	}
	public OfertaDTO getOfferDTO() {
		return offerDTO;
	}
	public void setOfferDTO(OfertaDTO offerDTO) {
		this.offerDTO = offerDTO;
	}
}
