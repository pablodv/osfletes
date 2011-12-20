package com.osfletes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.osfletes.dao.hibernate.AnuncioMultipleLocalizadoDAO;
import com.osfletes.model.AnuncioMultipleLocalizado;
import com.osfletes.service.interfaces.IAnuncioService;
import com.osfletes.service.interfaces.IDireccionService;
import com.osfletes.web.dto.FiltroDTO;

@Service(value="anuncioMultipleLocalizadoService")
public class AnuncioMultipleLocalizadoService extends GenericServiceImplementacion<AnuncioMultipleLocalizado,AnuncioMultipleLocalizadoDAO> implements IAnuncioService{

	@Autowired
	IDireccionService direccionService;
	
	

	public void setDireccionService(IDireccionService direccionService) {
		this.direccionService = direccionService;
	}
	

	@Override
	public List<AnuncioMultipleLocalizado> findAnuncios(FiltroDTO filtro) {
		return this.dao.findAnuncios(filtro);
	}

}
