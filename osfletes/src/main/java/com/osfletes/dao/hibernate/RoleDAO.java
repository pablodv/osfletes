package com.osfletes.dao.hibernate;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.osfletes.dao.interfaces.IRoleDAO;
import com.osfletes.security.Role;
import com.osfletes.security.User;
import com.osfletes.web.dto.RoleFilterDTO;
import com.osfletes.web.model.ResultadoPaginado;

@Repository
public class RoleDAO extends GenericHibernateDAO<Role> implements IRoleDAO {

	@Autowired
	public RoleDAO(SessionFactory sf) {
		super(sf);
	}

	@Override
	public Class<Role> getRepresentedClass() {
		return Role.class;
	}

	public Role getRole(String rolName) {
		Criteria criteria = this.createCriteria();
		criteria.add(Restrictions.eq("role", rolName));
		return findUniqueByCriteria(criteria);
	}

	@Override
	public ResultadoPaginado<Role> getRoles(RoleFilterDTO filter) {
		Criteria criteria = this.createCriteria();
		if(filter.getRole() !=null && !filter.getRole().trim().isEmpty())
			criteria.add(Restrictions.eq("role", filter.getRole()));
		return findPageByCriteria(criteria, filter);
	}

}
