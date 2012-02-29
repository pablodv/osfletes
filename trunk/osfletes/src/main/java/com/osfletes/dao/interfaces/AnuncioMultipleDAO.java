package com.osfletes.dao.interfaces;

import com.osfletes.model.AnuncioMultipleLocalizado;
import com.osfletes.web.dto.FiltroAnuncioDTO;
import com.osfletes.web.dto.ProviderAnnounceFilterDTO;
import com.osfletes.web.model.ResultadoPaginado;

public interface AnuncioMultipleDAO extends IGenericDAO<AnuncioMultipleLocalizado> {

	/**
	 * Retorna un segmento (pagina) de aquellos anuncios que cumplan con los filtros
	 * @param filtro
	 * @return
	 */
	ResultadoPaginado<AnuncioMultipleLocalizado> findAnuncios(FiltroAnuncioDTO filtro);

	/**
	 * Retorna el Anuncio con id <b>announcementId</b> correspondiente al Usuario <b>userId</b> 
	 * @param announcementId
	 * @param userId
	 * @return
	 */
	public AnuncioMultipleLocalizado findAnnoucement(Long announcementId, Long userId);

	/**
	 * Que mas decir, especifica si el anuncio con id: <b>announcementId</b> existe para el usario con id: <b>userId</b>
	 * @param announcementId
	 * @param userId
	 * @return
	 */
	public boolean existAnnouncement(Long announcementId, Long userId);

	/**
	 * 
	 * @param filter
	 * @return
	 */
	public ResultadoPaginado<AnuncioMultipleLocalizado> findAnuncios(ProviderAnnounceFilterDTO filter);

}
