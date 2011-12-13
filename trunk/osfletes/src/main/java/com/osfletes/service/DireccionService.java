package com.osfletes.service;

import org.springframework.stereotype.Service;

import com.osfletes.dao.hibernate.DireccionDAO;
import com.osfletes.model.Direccion;
import com.osfletes.service.interfaces.IDireccionService;

@Service(value="direccionService")
public class DireccionService extends GenericServiceImplementacion<Direccion, DireccionDAO> implements IDireccionService{

}
