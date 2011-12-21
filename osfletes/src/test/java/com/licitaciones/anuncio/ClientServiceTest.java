package com.licitaciones.anuncio;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.osfletes.mapper.ClienteMapper;
import com.osfletes.model.Cliente;
import com.osfletes.service.interfaces.IGenericService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/AnuncioServiceTest-context.xml"})
public class ClientServiceTest {
	
	@Autowired
	protected IGenericService<Cliente> clientService;
	
	@Autowired
	private ClienteMapper clienteMapper;

	@Test
	public void saveClient(){
		
	}
	
	
	public IGenericService<Cliente> getClientService() {
		return clientService;
	}

	public void setClientService(IGenericService<Cliente> clientService) {
		this.clientService = clientService;
	}

	public ClienteMapper getClienteMapper() {
		return clienteMapper;
	}

	public void setClienteMapper(ClienteMapper clienteMapper) {
		this.clienteMapper = clienteMapper;
	}


}
