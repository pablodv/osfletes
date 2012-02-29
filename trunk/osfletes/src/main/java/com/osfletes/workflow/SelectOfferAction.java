package com.osfletes.workflow;

import com.licitaciones.EstadoAction;
import com.licitaciones.exception.InvalidTransactionException;
import com.osfletes.model.Anuncio;
import com.osfletes.model.Contract;
import com.osfletes.model.Oferta;
import com.osfletes.model.ProcesarNoSeleccionados;
import com.osfletes.service.ServiceLocator;

public class SelectOfferAction implements EstadoAction<Anuncio> {

	@Override
	public void exceute(Anuncio obj, Object... args) throws InvalidTransactionException {
		Anuncio announcement = (Anuncio)obj;
		Long offerId = (Long) args[0];
		Oferta offer = ServiceLocator.getOfertaService().getById(offerId);

		Contract contract = new Contract();
		contract.setAnnouncement(announcement);
		contract.setOffer(offer);
		ServiceLocator.getContractService().save(contract);
		ServiceLocator.getOfertaService().selectOffer(offer);
		//TODO enviar mail a cliente
		ServiceLocator.getMailService().sendMail();
		new ProcesarNoSeleccionados(contract); 
		
	}

}
