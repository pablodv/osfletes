package com.osfletes.mapper;

import java.util.ArrayList;
import java.util.List;

import com.osfletes.model.AnuncioMultipleLocalizado;
import com.osfletes.model.Direccion;
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
		dto.setDescripcion(model.getDescripcion());
		dto.setId(model.getId());
		
		return dto;
	}

	public List<AnuncioMultipleDTO> toDTO(List<AnuncioMultipleLocalizado> list) {
		
		List<AnuncioMultipleDTO> listaDtos = new ArrayList<AnuncioMultipleDTO>();
		AnuncioMultipleDTO dto =null;
		List<Direccion> lista;
		for (AnuncioMultipleLocalizado model : list) {
			lista = model.getListaDirecciones().fetch();
			dto = toDTO(model);
			for (Direccion dir : lista) {
				dto.setDireccion1(dir.direccion);
			}
			listaDtos.add(dto);
		}
		return listaDtos;
	}
	
	
	@Override
	public AnuncioMultipleLocalizado toModel(AnuncioMultipleDTO dto) {
		
		AnuncioMultipleLocalizado model = new AnuncioMultipleLocalizado();
		
		model.setFechaCierre(dto.getFechaCierre());
		model.setFechaCreacion(dto.getFechaCreacion());
		model.setFechaDesde(dto.getFechaDesde());
		model.setFechaHasta(dto.getFechaHasta());
		model.setHoraDesde(dto.getHoraDesde());
		model.setHoraHasta(dto.getHoraHasta());
		model.setDescripcion(dto.getDescripcion());
		model.setId(dto.getId());
		
		return model;
	}

}