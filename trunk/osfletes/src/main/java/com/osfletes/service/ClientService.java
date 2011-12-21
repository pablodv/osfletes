package com.osfletes.service;

import org.springframework.stereotype.Service;

import com.osfletes.dao.hibernate.ClienteDAO;
import com.osfletes.model.Cliente;
import com.osfletes.service.interfaces.IClienteService;

@Service(value="clienteService")
public class ClientService extends GenericServiceImplementacion<Cliente,ClienteDAO> implements IClienteService{

}
