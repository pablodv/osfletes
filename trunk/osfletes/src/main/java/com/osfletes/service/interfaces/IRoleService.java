package com.osfletes.service.interfaces;

import org.springframework.transaction.annotation.Transactional;

import com.osfletes.security.Role;

public interface IRoleService extends IGenericService<Role> {

	@Transactional(readOnly=true)
	public Role getClientRole();

}
