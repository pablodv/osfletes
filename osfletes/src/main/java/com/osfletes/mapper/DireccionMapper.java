package com.osfletes.mapper;

import java.util.List;

import com.osfletes.model.Direccion;
import com.osfletes.web.dto.DireccionDTO;

public class DireccionMapper implements IMapper<Direccion,DireccionDTO>{

	@Override
	public DireccionDTO toDTO(Direccion model) {
		DireccionDTO dto = new DireccionDTO();
		
		if(model.direccion!=null){
			dto.setDireccion(model.direccion);
		}
		if(model.getId()!=null){
			dto.setId(model.getId());
		}
		if(model.latitud!=null){
			dto.setLatitud(model.latitud);
		}
		if(model.longitud!=null){
			dto.setLongitud(model.longitud);
		}
		if(model.posicion!=null){
			dto.setPosicion(model.posicion);
		}
		
		
		return dto;
	}

	@Override
	public Direccion toModel(DireccionDTO dto) {
		Direccion model = new Direccion();

		if(dto.getDireccion()!=null){
			model.direccion = dto.getDireccion();
		}
		if(dto.getLatitud()!=null){
			model.latitud = dto.getLatitud();
		}
		if(dto.getLongitud()!=null){
			model.longitud = dto.getLongitud();
		}
		if(dto.getPosicion()!=null){
			model.posicion = dto.getPosicion();
		}
		
		return model;
	}
	
	public Direccion fromAnuncioDTOToModel(String direccion){
		Direccion model = new Direccion();
		
		model.direccion = direccion;
		
		return model;
	}

	@Override
	public List<DireccionDTO> listToDto(List<Direccion> lista) {
		// TODO Auto-generated method stub
		return null;
	}


}
