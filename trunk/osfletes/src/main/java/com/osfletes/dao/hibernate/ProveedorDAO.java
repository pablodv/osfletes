package com.osfletes.dao.hibernate;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.osfletes.model.Proveedor;

@Repository
public class ProveedorDAO extends GenericHibernateDAO<Proveedor> {

	@Autowired
	public ProveedorDAO(SessionFactory sf) {
		super(sf);
	}

	@Override
	public Class<Proveedor> getRepresentedClass() {
		return Proveedor.class;
	}

	public boolean existUserWithMail(String mail) {
		Criteria criteria = createCriteria();
		criteria.add(Restrictions.eq("username", mail));
		return this.exist(criteria);
	}

}
