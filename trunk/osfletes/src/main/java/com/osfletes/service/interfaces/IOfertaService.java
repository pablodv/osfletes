package com.osfletes.service.interfaces;

import java.util.List;

import com.osfletes.model.Oferta;
import com.osfletes.web.dto.OfferFilterDTO;
import com.osfletes.web.model.ResultadoPaginado;

public interface IOfertaService extends IGenericService<Oferta> {

	public ResultadoPaginado<Oferta> findOffers(OfferFilterDTO filter);

	public Oferta findOffer(Long announcementId, Long offerId);

	public void selectOffer(Oferta offer);

	public void noSelectOffer(Oferta Offer);

	public void cancelOffer(Long offerId);

	public List<Oferta> findNonSelectedOffers(Long announcementId, Long offerId);

	public boolean existOffer(Long offerId, Long userId);


}
