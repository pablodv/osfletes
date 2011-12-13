package com.osfletes.dao.hibernate;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.osfletes.model.Oferta;

@Repository
public class OfertaDAO extends GenericHibernateDAO<Oferta> {

	
	@Autowired
	public OfertaDAO(SessionFactory sf) {
		super(sf);
	}

	@Override
	public Class<Oferta> getRepresentedClass() {
		return Oferta.class;
	}

}
