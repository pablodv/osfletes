package com.osfletes.service;

import org.springframework.stereotype.Service;

import com.osfletes.dao.hibernate.ClienteDAO;
import com.osfletes.model.Cliente;
import com.osfletes.service.interfaces.IClienteService;
import com.osfletes.web.dto.RegistroDTO;

@Service(value="clienteService")
public class ClientService extends GenericServiceImplementacion<Cliente,ClienteDAO> implements IClienteService{

	@Override
	public void createClient(RegistroDTO registro) {
		Cliente cliente = new Cliente();
		cliente.setUsername(registro.getMail());
		cliente.setPassword(registro.getPassword());
				
	}

}
