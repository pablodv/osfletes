package com.osfletes.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.osfletes.dao.hibernate.ProveedorDAO;
import com.osfletes.model.Proveedor;
import com.osfletes.security.Role;
import com.osfletes.service.interfaces.IProveedorService;
import com.osfletes.web.dto.SignupProviderDTO;

@Service(value="proveedorService")
public class ProveedorService extends GenericServiceImplementacion<Proveedor,ProveedorDAO> implements IProveedorService{

	@Override
	@Transactional
	public void createProvider(SignupProviderDTO reg) {
		Proveedor provider = new Proveedor();
		Role role = ServiceLocator.getRoleService().getProviderRole();
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>(1);
		authorities.add(role);
		provider.setUsername(reg.getMail());
		provider.setPassword(reg.getPassword());
		provider.setAuthorities(authorities);
		
		this.save(provider);
	}

	@Override
	public boolean existUserWithMail(String mail) {
		return dao.existUserWithMail(mail);
	}

}
