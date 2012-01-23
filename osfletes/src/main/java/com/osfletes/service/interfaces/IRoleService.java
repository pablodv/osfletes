package com.osfletes.service.interfaces;

import org.springframework.transaction.annotation.Transactional;

import com.osfletes.security.Role;
import com.osfletes.web.dto.RoleFilterDTO;
import com.osfletes.web.model.ResultadoPaginado;

public interface IRoleService extends IGenericService<Role> {

	public Role getClientRole();

	public Role getProviderRole();

	@Transactional(readOnly=true)
	public ResultadoPaginado<Role> getRoles(RoleFilterDTO filter);

}
