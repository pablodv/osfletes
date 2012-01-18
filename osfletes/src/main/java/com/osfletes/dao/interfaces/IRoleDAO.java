package com.osfletes.dao.interfaces;

import com.osfletes.security.Role;

public interface IRoleDAO extends IGenericDAO<Role> {

	public Role getRole(String rolName);

}
