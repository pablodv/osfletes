package com.osfletes.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.osfletes.service.interfaces.IAnuncioService;

public class ServiceLocator {

  private static ServiceLocator INSTANCE;

  private IAnuncioService service;
  
  // constructor privado
  private ServiceLocator() {/*Singleton*/}

  public static ServiceLocator getInstance() {
    if (INSTANCE == null) {
      INSTANCE = new ServiceLocator();
    }
    return INSTANCE;
  }

  
  public static IAnuncioService getAnuncioService() {
    return INSTANCE.service;
  }

  @Autowired
  public void setAnuncioService(IAnuncioService service) {
    this.service = service;
  }
}
