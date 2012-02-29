package com.osfletes.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.licitaciones.Workflow;
import com.licitaciones.exception.BusinessException;
import com.licitaciones.exception.InvalidTransactionException;
import com.osfletes.dao.hibernate.OfertaDAO;
import com.osfletes.model.Anuncio;
import com.osfletes.model.Oferta;
import com.osfletes.model.OfertaWFTransactionsEnum;
import com.osfletes.service.interfaces.IOfertaService;
import com.osfletes.web.controller.JsonMesagesResolver;
import com.osfletes.web.dto.OfferFilterDTO;
import com.osfletes.web.model.ResultadoPaginado;

@Service(value="ofertaService")
public class OfertaService extends GenericServiceImplementacion<Oferta,OfertaDAO> implements IOfertaService {

	@Autowired
	@Qualifier(value="workflow-oferta")
	Workflow workflow;
	
	@Override
	public ResultadoPaginado<Oferta> findOffers(OfferFilterDTO filter) {
		return this.dao.findOffers(filter);
	}

	@Override
	public Serializable save(Oferta offer) {
		Anuncio announcement = offer.getAnuncio();
		if(announcement.getFechaDesde().compareTo(offer.getFechaServicio()) > 0 || announcement.getFechaHasta().compareTo(offer.getFechaServicio()) < 0){
			throw new BusinessException(JsonMesagesResolver.getMessage("offer.invalid.date",null, null));
		}
		return super.save(offer);
	}

	@Override
	public Oferta findOffer(Long announcementId, Long offerId) {
		return this.dao.findOffers(announcementId, offerId);
	}

	@Override
	public void selectOffer(Oferta offer) {
		ejecutarAccion(offer, OfertaWFTransactionsEnum.CLIENTE_SELECCIONA_OFERTA.getName());
	}
	
	
	
	@Override
	public void noSelectOffer(Oferta offer) {
		System.out.println("no select Offer");
		ejecutarAccion(offer, OfertaWFTransactionsEnum.CLIENTE_NO_SELECCIONA_OFERTA.getName() );		
	}

	@Override
	public void cancelOffer(Long offerId) {
		Oferta offer = this.getById(offerId);
		ejecutarAccion(offer, OfertaWFTransactionsEnum.PROVEEDOR_CANCELA_OFERTA.getName());
	}
	
	private void ejecutarAccion(Oferta offer, String nombreTransaccion, Object... args){
		try {
			workflow.executeAction(offer.getState(), nombreTransaccion ,offer,args);
		} catch (InvalidTransactionException e) {
			throw new BusinessException(JsonMesagesResolver.getMessage("error.action.invalid", null, null));
		}
		
		this.saveOrUpdate(offer);
	}

	@Override
	public List<Oferta> findNonSelectedOffers(Long announcementId, Long offerId) {
		return this.dao.findNonSelectedOffers(announcementId,offerId);
	}

	@Override
	public boolean existOffer(Long offerId, Long providerId) {
		return this.dao.existOffer(offerId, providerId);
	}

	
	
	

}
