package com.osfletes.service.interfaces;

import com.osfletes.model.Cliente;
import com.osfletes.web.dto.RegistroDTO;

public interface IClienteService extends IGenericService<Cliente> {

	void createClient(RegistroDTO registro);

}
