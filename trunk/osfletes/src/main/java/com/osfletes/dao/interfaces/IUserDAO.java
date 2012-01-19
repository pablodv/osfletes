package com.osfletes.dao.interfaces;

import org.springframework.security.core.userdetails.UserDetails;

import com.osfletes.security.User;
import com.osfletes.web.dto.UserFilterDTO;
import com.osfletes.web.model.ResultadoPaginado;

public interface IUserDAO extends IGenericDAO<User> {

	public UserDetails loadUserByUserName(String userName);

	public ResultadoPaginado<User> getUsers(UserFilterDTO filter);

}
