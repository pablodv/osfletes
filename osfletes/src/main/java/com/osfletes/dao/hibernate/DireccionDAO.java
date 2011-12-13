package com.osfletes.dao.hibernate;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.osfletes.model.Direccion;

@Repository
public class DireccionDAO extends GenericHibernateDAO<Direccion> {

	@Autowired
	public DireccionDAO(SessionFactory sf) {
		super(sf);
	}

	@Override
	public Class<Direccion> getRepresentedClass() {
		return Direccion.class;
	}

}
