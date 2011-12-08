package com.osfletes.service;

import org.springframework.stereotype.Service;

import com.osfletes.dao.DireccionDAO;
import com.osfletes.model.Direccion;

@Service(value="direccionService")
public class DireccionService extends GenericSienaServiceImpl<Direccion, DireccionDAO> implements IDireccionService{

}
