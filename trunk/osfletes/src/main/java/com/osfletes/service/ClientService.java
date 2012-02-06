package com.osfletes.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.licitaciones.exception.BusinessException;
import com.osfletes.dao.hibernate.ClienteDAO;
import com.osfletes.model.Cliente;
import com.osfletes.security.Role;
import com.osfletes.service.interfaces.IClienteService;
import com.osfletes.web.controller.JsonMesagesResolver;
import com.osfletes.web.dto.SignupClientDTO;

@Service(value="clienteService")
public class ClientService extends GenericServiceImplementacion<Cliente,ClienteDAO> implements IClienteService{

	@Override
	@Transactional
	public void createClient(SignupClientDTO registro) {
		Cliente cliente = new Cliente();
		if(dao.existUserWithMail(registro.getMail())){
			throw new BusinessException(JsonMesagesResolver.getMessage("user.not.available", null, null));
		}
		cliente.setUsername(registro.getMail());
		cliente.setPassword(registro.getPassword());
		Role rol = ServiceLocator.getRoleService().getClientRole();
		
		
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>(1);
		authorities.add(rol);
		cliente.setAuthorities(authorities);
		this.save(cliente);
	}

	@Override
	public boolean existUserWithMail(String mail) {
		return dao.existUserWithMail(mail);
	}
	
	

}
