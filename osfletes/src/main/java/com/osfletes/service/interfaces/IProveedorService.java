package com.osfletes.service.interfaces;

import com.osfletes.model.Proveedor;
import com.osfletes.web.dto.SignupProviderDTO;

public interface IProveedorService extends IGenericService<Proveedor> {

	public void createProvider(SignupProviderDTO reg);
	
	public boolean existUserWithMail(String mail);

}
