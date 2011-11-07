package com.osfletes.service;

import org.springframework.beans.factory.annotation.Autowired;

public class ServiceLocator {

  private static ServiceLocator INSTANCE;

  private AnuncioService service;
  
  // constructor privado
  private ServiceLocator() {/*Singleton*/}

  public static ServiceLocator getInstance() {
    if (INSTANCE == null) {
      INSTANCE = new ServiceLocator();
    }
    return INSTANCE;
  }

  
  public static AnuncioService getAnuncioService() {
    return INSTANCE.service;
  }

  @Autowired
  public void setAnuncioService(AnuncioService service) {
    this.service = service;
  }
}
