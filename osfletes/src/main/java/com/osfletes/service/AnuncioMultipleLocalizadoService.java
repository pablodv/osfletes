package com.osfletes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import siena.PersistenceManagerFactory;

import com.osfletes.dao.AnuncioMultipleLocalizadoDAO;
import com.osfletes.model.AnuncioMultipleLocalizado;
import com.osfletes.model.Direccion;

@Service(value="anuncioMultipleLocalizadoService")
public class AnuncioMultipleLocalizadoService extends GenericSienaServiceImpl<AnuncioMultipleLocalizado,AnuncioMultipleLocalizadoDAO> implements IAnuncioService{

	@Autowired
	IDireccionService direccionService;
	
	

	public void setDireccionService(IDireccionService direccionService) {
		this.direccionService = direccionService;
	}

	@Override
	@Transactional
	public void saveRollback(AnuncioMultipleLocalizado obj) {
		obj.insert();
		obj.getPersistenceManager().save(obj);
		throw new RuntimeException();
	}

	@Transactional
	public void saveWithAddresses(AnuncioMultipleLocalizado anuncio,List<Direccion> addresses) {
		for (Direccion direccion : addresses) {
			direccion.owner = anuncio;
		}
		this.dao.save(anuncio);
	}	
	
	@Transactional
	public void delete(AnuncioMultipleLocalizado anuncio){
		List<Direccion> direcciones = anuncio.getListaDirecciones().fetch();
		PersistenceManagerFactory.getPersistenceManager(Direccion.class).delete(direcciones);
		
		anuncio.delete();
	}

	
	

}
