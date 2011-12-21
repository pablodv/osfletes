package com.licitaciones.cliente;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.osfletes.mapper.ClienteMapper;
import com.osfletes.model.Cliente;
import com.osfletes.service.interfaces.IClienteService;
import com.osfletes.service.interfaces.IGenericService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/AnuncioServiceTest-context.xml"})
public class ClientServiceTest {
	
	@Autowired
	protected IClienteService clientService;
	
	@Autowired
	private ClienteMapper clienteMapper;

	@Test
	public void saveClient(){
		Cliente cli = new Cliente();
		cli.setUsername("carlitox");
		cli.setPassword("carlitox");
		
		clientService.saveOrUpdate(cli);
	}
	
	
	public IGenericService<Cliente> getClientService() {
		return clientService;
	}

	public ClienteMapper getClienteMapper() {
		return clienteMapper;
	}

	public void setClienteMapper(ClienteMapper clienteMapper) {
		this.clienteMapper = clienteMapper;
	}


	public void setClientService(IClienteService clientService) {
		this.clientService = clientService;
	}


}
