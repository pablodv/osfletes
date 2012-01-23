package com.osfletes.service;

import org.springframework.stereotype.Service;

import com.osfletes.dao.interfaces.IRoleDAO;
import com.osfletes.security.Role;
import com.osfletes.security.RolesEnum;
import com.osfletes.service.interfaces.IRoleService;
import com.osfletes.web.dto.RoleFilterDTO;
import com.osfletes.web.model.ResultadoPaginado;

@Service(value="roleService")
public class RoleService extends GenericServiceImplementacion<Role, IRoleDAO> implements IRoleService {

	@Override
	public Role getClientRole() {
		return dao.getRole(RolesEnum.ROLE_CLIENT.getRolName());
	}

	@Override
	public Role getProviderRole() {
		return dao.getRole(RolesEnum.ROLE_PROV.getRolName());
	}

	@Override
	
	public ResultadoPaginado<Role> getRoles(RoleFilterDTO filter) {
		return dao.getRoles(filter);
	}

}
