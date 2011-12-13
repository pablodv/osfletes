package com.osfletes.service.interfaces;

import java.util.List;

import com.osfletes.model.AnuncioMultipleLocalizado;
import com.osfletes.web.dto.FiltroDTO;

public interface IAnuncioService extends IGenericService<AnuncioMultipleLocalizado> {
	
	
	
	/**
	 * Busca los anuncios 
	 * @param filtro
	 * @return
	 */
	public List<AnuncioMultipleLocalizado> findAnuncios(FiltroDTO filtro);

}
