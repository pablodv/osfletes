package com.osfletes.dao.hibernate;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.osfletes.model.Anuncio;

public class AnuncioDAO extends GenericHibernateDAO<Anuncio>{

	@Autowired
	public AnuncioDAO(SessionFactory sf) {
		super(sf);
	}

	@Override
	public Class<Anuncio> getRepresentedClass() {
		return Anuncio.class;
	}
	
}
