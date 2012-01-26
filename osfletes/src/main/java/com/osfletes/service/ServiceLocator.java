package com.osfletes.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.osfletes.service.interfaces.IAnuncioService;
import com.osfletes.service.interfaces.IClienteService;
import com.osfletes.service.interfaces.IProveedorService;
import com.osfletes.service.interfaces.IRoleService;
import com.osfletes.service.interfaces.IUserService;

public class ServiceLocator {

  private static ServiceLocator INSTANCE;

  private IAnuncioService anuncioService;
  private IUserService userService;
  private IRoleService roleService;
  private IProveedorService providerService;
  private IClienteService clienteService;
  
  // constructor privado
  private ServiceLocator() {/*Singleton*/}

  public static ServiceLocator getInstance() {
    if (INSTANCE == null) {
      INSTANCE = new ServiceLocator();
    }
    return INSTANCE;
  }

  
  public static IAnuncioService getAnuncioService() {
    return INSTANCE.anuncioService;
  }

  @Autowired
  public void setAnuncioService(IAnuncioService anuncioService) {
    this.anuncioService = anuncioService;
  }

	public static IUserService getUserService() {
		return INSTANCE.userService;
	}
	
	@Autowired
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	
	public static IRoleService getRoleService() {
		return INSTANCE.roleService;
	}
	
	@Autowired
	public void setRoleService(IRoleService roleService) {
		this.roleService = roleService;
	}

	public static IProveedorService getProviderService() {
		return INSTANCE.providerService;
	}

	@Autowired
	public void setProviderService(IProveedorService providerService) {
		this.providerService = providerService;
	}

	public static IClienteService getClienteService() {
		return INSTANCE.clienteService;
	}

	@Autowired
	public void setClienteService(IClienteService clienteService) {
		this.clienteService = clienteService;
	}
	
	
  
  
}
