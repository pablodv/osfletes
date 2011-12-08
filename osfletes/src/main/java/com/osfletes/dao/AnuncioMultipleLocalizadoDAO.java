package com.osfletes.dao;

import org.springframework.stereotype.Repository;

import com.osfletes.model.AnuncioMultipleLocalizado;

@Repository
public class AnuncioMultipleLocalizadoDAO extends GenericSienaDAO<AnuncioMultipleLocalizado> {

	@Override
	protected Class<AnuncioMultipleLocalizado> getRepresentedClass() {
		return AnuncioMultipleLocalizado.class;
	}

}
