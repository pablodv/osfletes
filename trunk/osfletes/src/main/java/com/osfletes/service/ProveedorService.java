package com.osfletes.service;

import org.springframework.stereotype.Service;

import com.osfletes.dao.hibernate.ProveedorDAO;
import com.osfletes.model.Proveedor;
import com.osfletes.service.interfaces.IProveedorService;

@Service(value="proveedorService")
public class ProveedorService extends GenericServiceImplementacion<Proveedor,ProveedorDAO> implements IProveedorService{

}
