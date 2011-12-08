package com.osfletes.dao;

import org.springframework.stereotype.Repository;

import com.osfletes.model.Oferta;

@Repository
public class OfertaDAO extends GenericSienaDAO<Oferta> {

	@Override
	protected Class<Oferta> getRepresentedClass() {
		return Oferta.class;
	}

}
