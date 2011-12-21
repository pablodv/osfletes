package com.osfletes.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.osfletes.model.AnuncioMultipleLocalizado;
import com.osfletes.model.Direccion;
import com.osfletes.web.dto.AnuncioMultipleDTO;

public class AnuncioMultipleMapper implements IMapper<AnuncioMultipleLocalizado,AnuncioMultipleDTO>{

	@Autowired
	private DireccionMapper direccionMapper;

	
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
		
		Direccion direccion1 = direccionMapper.fromAnuncioDTOToModel(dto.getDireccion1());
		direccion1.setPosicion(1);

		Direccion direccion2 = direccionMapper.fromAnuncioDTOToModel(dto.getDireccion2());
		direccion2.setPosicion(2);

		model.getListaDirecciones().add(direccion1);
		model.getListaDirecciones().add(direccion2);
		
		return model;
	}

	@Override
	public List<AnuncioMultipleDTO> listToDto(List<AnuncioMultipleLocalizado> lista) {
		List<AnuncioMultipleDTO> listaDtos = new ArrayList<AnuncioMultipleDTO>();
		AnuncioMultipleDTO dto =null;
		for (AnuncioMultipleLocalizado model : lista) {
			dto = toDTO(model);
			listaDtos.add(dto);
		}
		return listaDtos;
	}

	public DireccionMapper getDireccionMapper() {
		return direccionMapper;
	}

	public void setDireccionMapper(DireccionMapper direccionMapper) {
		this.direccionMapper = direccionMapper;
	}

}
