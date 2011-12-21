package com.osfletes.mapper;

import java.util.List;

import com.osfletes.model.Oferta;
import com.osfletes.web.dto.OfertaDTO;

public class OfertaMapper implements IMapper<Oferta,OfertaDTO>{

	@Override
	public OfertaDTO toDTO(Oferta model) {
		OfertaDTO ofertaDTO = new OfertaDTO();
		
		ofertaDTO.setId(model.getId());
		ofertaDTO.setValorOferta(model.getValorOferta());
		ofertaDTO.setFechaServicio(model.getFechaServicio());
		
		return null;
	}

	@Override
	public Oferta toModel(OfertaDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OfertaDTO> listToDto(List<Oferta> lista) {
		// TODO Auto-generated method stub
		return null;
	}

}
