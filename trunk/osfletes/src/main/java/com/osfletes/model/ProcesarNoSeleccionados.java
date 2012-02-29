package com.osfletes.model;

import com.osfletes.service.ServiceLocator;
import com.osfletes.service.interfaces.IOfertaService;


public class ProcesarNoSeleccionados implements Runnable {

	private Contract contract;
	
	
	
	public ProcesarNoSeleccionados(Contract contract) {
		super();
		this.contract = contract;
	}



	@Override
	public void run() {
		IOfertaService ofertaService = ServiceLocator.getOfertaService();
		
		ofertaService.findNonSelectedOffers(contract.getAnnouncement().getId(),contract.getOffer().getId());
		
	}

}
