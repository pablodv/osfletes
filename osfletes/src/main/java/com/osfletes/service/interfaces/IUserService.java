package com.osfletes.service.interfaces;

import org.springframework.transaction.annotation.Transactional;

import com.osfletes.security.User;
import com.osfletes.web.dto.UserFilterDTO;
import com.osfletes.web.model.ResultadoPaginado;

public interface IUserService extends IGenericService<User> {

	@Transactional(readOnly=true)
	ResultadoPaginado<User> getUsers(UserFilterDTO filter);

}
