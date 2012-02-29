package com.osfletes.mapper;

import java.util.List;

import com.osfletes.model.Anuncio;
import com.osfletes.model.Oferta;
import com.osfletes.service.ServiceLocator;
import com.osfletes.web.dto.OfertaDTO;

public class OfferMapper implements IMapper<Oferta,OfertaDTO>{

	@Override
	public OfertaDTO toDTO(Oferta model) {
		OfertaDTO ofertaDTO = new OfertaDTO();
		
		ofertaDTO.setId(model.getId());
		ofertaDTO.setValue(model.getValorOferta());
		ofertaDTO.setServiceDate(model.getFechaServicio());
		
		return ofertaDTO;
	}

	@Override
	public Oferta toModel(OfertaDTO dto) {
		Oferta offer = new Oferta();
		Anuncio announcement = ServiceLocator.getAnuncioService().getById(dto.getAnnouncementId());
		offer.setAnuncio(announcement);
		offer.setValorOferta(dto.getValue());
		offer.setFechaServicio(dto.getServiceDate());
		return offer;
	}

	@Override
	public List<OfertaDTO> listToDto(List<Oferta> lista) {
		// TODO Auto-generated method stub
		return null;
	}

}
