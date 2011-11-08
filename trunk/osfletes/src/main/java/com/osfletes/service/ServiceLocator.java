package com.osfletes.service;

import org.springframework.beans.factory.annotation.Autowired;

public class ServiceLocator {

  private static ServiceLocator INSTANCE;

  private AnuncioMultipleLocalizadoService service;
  
  // constructor privado
  private ServiceLocator() {/*Singleton*/}

  public static ServiceLocator getInstance() {
    if (INSTANCE == null) {
      INSTANCE = new ServiceLocator();
    }
    return INSTANCE;
  }

  
  public static AnuncioMultipleLocalizadoService getAnuncioService() {
    return INSTANCE.service;
  }

  @Autowired
  public void setAnuncioService(AnuncioMultipleLocalizadoService service) {
    this.service = service;
  }
}
