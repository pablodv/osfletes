package com.osfletes.mapper;

import java.util.ArrayList;
import java.util.List;

import com.osfletes.model.AnuncioMultipleLocalizado;
import com.osfletes.web.dto.AnuncioMultipleDTO;

public class AnuncioMultipleMapper implements IMapper<AnuncioMultipleLocalizado,AnuncioMultipleDTO>{


	@Override
	public AnuncioMultipleDTO toDTO(AnuncioMultipleLocalizado model) {
		AnuncioMultipleDTO dto = new AnuncioMultipleDTO();
		
		dto.setFechaCierre(model.getFechaCierre());
		dto.setFechaCreacion(model.getFechaCreacion());
		dto.setFechaDesde(model.getFechaDesde());
		dto.setFechaHasta(model.getFechaHasta());
		dto.setHoraDesde(model.getHoraDesde());
		dto.setHoraHasta(model.getHoraHasta());
		dto.setId(model.getId());
		
		return dto;
	}

	public List<AnuncioMultipleDTO> toDTO(List<AnuncioMultipleLocalizado> list) {
		
		List<AnuncioMultipleDTO> listaDtos = new ArrayList<AnuncioMultipleDTO>();
		AnuncioMultipleDTO dto =null;
		for (AnuncioMultipleLocalizado model : list) {
			dto = toDTO(model);
			listaDtos.add(dto);
		}
		return listaDtos;
	}
	
	
	@Override
	public AnuncioMultipleLocalizado toModel(AnuncioMultipleDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
