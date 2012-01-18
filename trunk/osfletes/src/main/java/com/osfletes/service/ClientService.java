package com.osfletes.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.osfletes.dao.hibernate.ClienteDAO;
import com.osfletes.model.Cliente;
import com.osfletes.security.Role;
import com.osfletes.service.interfaces.IClienteService;
import com.osfletes.web.dto.RegistroDTO;

@Service(value="clienteService")
public class ClientService extends GenericServiceImplementacion<Cliente,ClienteDAO> implements IClienteService{

	@Override
	@Transactional
	public void createClient(RegistroDTO registro) {
		Cliente cliente = new Cliente();
		cliente.setUsername(registro.getMail());
		cliente.setPassword(registro.getPassword());
		Role rol = ServiceLocator.getRoleService().getClientRole();
		
		
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>(1);
		authorities.add(rol);
		cliente.setAuthorities(authorities);
		this.save(cliente);
	}

}
