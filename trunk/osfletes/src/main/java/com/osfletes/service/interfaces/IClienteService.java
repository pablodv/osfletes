package com.osfletes.service.interfaces;

import com.osfletes.model.Cliente;
import com.osfletes.web.dto.SignupClientDTO;

public interface IClienteService extends IGenericService<Cliente> {

	void createClient(SignupClientDTO registro);

	public boolean existUserWithMail(String mail);
}
