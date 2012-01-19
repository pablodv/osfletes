package com.osfletes.service.interfaces;

import com.osfletes.security.Role;

public interface IRoleService extends IGenericService<Role> {

	public Role getClientRole();

	public Role getProviderRole();

}
