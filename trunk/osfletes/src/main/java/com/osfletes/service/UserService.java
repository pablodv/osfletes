package com.osfletes.service;

import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.osfletes.dao.interfaces.IUserDAO;
import com.osfletes.security.User;
import com.osfletes.service.interfaces.IUserService;
import com.osfletes.web.dto.UserFilterDTO;
import com.osfletes.web.model.ResultadoPaginado;

@Service(value="userService")
public class UserService extends GenericServiceImplementacion<User, IUserDAO> implements IUserService, UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String userName)	throws UsernameNotFoundException, DataAccessException {
		return dao.loadUserByUserName(userName);
	}

	@Override
	public ResultadoPaginado<User> getUsers(UserFilterDTO filter) {
		return this.dao.getUsers(filter);
	}

}
