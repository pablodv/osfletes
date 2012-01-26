package com.osfletes.dao.hibernate;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.osfletes.model.Cliente;

@Repository
public class ClienteDAO extends GenericHibernateDAO<Cliente> {

	@Autowired
	public ClienteDAO(SessionFactory sf) {
		super(sf);
	}

	@Override
	public Class<Cliente> getRepresentedClass() {
		return Cliente.class;
	}

	public boolean existUserWithMail(String mail) {
		Criteria criteria = createCriteria();
		criteria.add(Restrictions.eq("username", mail));
		return this.exist(criteria);
	}

}
