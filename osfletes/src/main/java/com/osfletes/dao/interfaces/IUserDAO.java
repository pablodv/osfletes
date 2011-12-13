package com.osfletes.dao.interfaces;

import org.springframework.security.core.userdetails.UserDetails;

import com.osfletes.security.User;

public interface IUserDAO extends IGenericDAO<User> {

	public UserDetails loadUserByUserName(String userName);

}
