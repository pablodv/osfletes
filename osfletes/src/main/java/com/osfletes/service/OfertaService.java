package com.osfletes.service;

import org.springframework.stereotype.Service;

import com.osfletes.model.Oferta;

@Service(value="ofertaService")
public class OfertaService extends GenericSienaServiceImpl<Oferta> implements IOfertaService {

	@Override
	protected Class<Oferta> getRepresentedClass() {
		return Oferta.class;
	}

}
