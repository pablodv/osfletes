package com.osfletes.dao;

import org.springframework.stereotype.Repository;

import com.osfletes.model.Direccion;

@Repository
public class DireccionDAO extends GenericSienaDAO<Direccion> {

	@Override
	protected Class<Direccion> getRepresentedClass() {
		return Direccion.class;
	}

}
