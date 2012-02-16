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

	@Transactional
	public void publicarAnuncio(Long anuncioId);

	@Transactional
	public void cancelarAnuncio(Long anuncioId);

	@Transactional
	public void seleccionarProveedor(Long anuncioId, Long ofertaId);

	@Transactional
	public void cerrarAnuncio(Long anuncioId);

	@Transactional
	public void cerrarVencido(Long anuncioId);

	@Transactional(readOnly=true)
	public AnuncioMultipleLocalizado findAnuncio(Long announcementId, Long userId);
}
