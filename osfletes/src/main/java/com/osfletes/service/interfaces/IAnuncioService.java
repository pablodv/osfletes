package com.osfletes.service.interfaces;

import org.springframework.transaction.annotation.Transactional;

import com.osfletes.model.AnuncioMultipleLocalizado;
import com.osfletes.web.dto.FiltroAnuncioDTO;
import com.osfletes.web.model.ResultadoPaginado;

public interface IAnuncioService extends IGenericService<AnuncioMultipleLocalizado> {
	
	
	
	/**
	 * Busca los anuncios 
	 * @param filtro
	 * @return
	 */
	@Transactional
	public ResultadoPaginado<AnuncioMultipleLocalizado> findAnuncios(FiltroAnuncioDTO filtro);

	public void publicarAnuncio(Long anuncioId);

	public void cancelarAnuncio(Long anuncioId);

	public void seleccionarProveedor(Long anuncioId, Long ofertaId);

	public void cerrarAnuncio(Long anuncioId);

	public void cerrarVencido(Long anuncioId);
}
