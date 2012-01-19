package com.osfletes.dao.hibernate;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.osfletes.dao.interfaces.IUserDAO;
import com.osfletes.security.User;
import com.osfletes.web.dto.UserFilterDTO;
import com.osfletes.web.model.ResultadoPaginado;



@Repository
public class UserDAO extends GenericHibernateDAO<User> implements IUserDAO {

	@Autowired
	public UserDAO(SessionFactory sf) {
		super(sf);
	}

	@Override
	public Class getRepresentedClass() {
		return User.class;
	}
	
	@Override
	public UserDetails loadUserByUserName(String userName) {
		return this.findUniqueByCriterion(Restrictions.eq("username",userName));
	}

	@Override
	public ResultadoPaginado<User> getUsers(UserFilterDTO filter) {
		Criteria criteria = this.createCriteria();
		if(filter.getUsername() != null && !filter.getUsername().trim().isEmpty())
			criteria.add(Restrictions.eq("username", filter.getUsername()));
		
		if(filter.getEnable() != null)
			criteria.add(Restrictions.eq("enable", filter.getEnable().booleanValue()));
		
		return findPageByCriteria(criteria, filter);
	}

}
