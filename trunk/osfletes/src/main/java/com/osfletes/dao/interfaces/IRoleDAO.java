package com.osfletes.dao.interfaces;

import com.osfletes.security.Role;
import com.osfletes.web.dto.RoleFilterDTO;
import com.osfletes.web.model.ResultadoPaginado;

public interface IRoleDAO extends IGenericDAO<Role> {

	public Role getRole(String rolName);

	public ResultadoPaginado<Role> getRoles(RoleFilterDTO filter);

}
