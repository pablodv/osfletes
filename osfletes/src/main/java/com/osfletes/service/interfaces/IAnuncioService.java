package com.osfletes.service.interfaces;

import java.util.List;

import com.osfletes.model.AnuncioMultipleLocalizado;
import com.osfletes.web.dto.FiltroAnuncioDTO;
import com.osfletes.web.model.ResultadoPaginado;

public interface IAnuncioService extends IGenericService<AnuncioMultipleLocalizado> {
	
	
	
	/**
	 * Busca los anuncios 
	 * @param filtro
	 * @return
	 */
	public ResultadoPaginado<AnuncioMultipleLocalizado> findAnuncios(FiltroAnuncioDTO filtro);

}
