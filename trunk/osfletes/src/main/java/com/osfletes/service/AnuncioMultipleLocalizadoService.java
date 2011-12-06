package com.osfletes.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import siena.PersistenceManagerFactory;

import com.osfletes.model.AnuncioMultipleLocalizado;
import com.osfletes.model.Direccion;

@Service(value="anuncioMultipleLocalizadoService")
public class AnuncioMultipleLocalizadoService extends GenericSienaServiceImpl<AnuncioMultipleLocalizado> implements IAnuncioService{

	@Override
	protected Class<AnuncioMultipleLocalizado> getRepresentedClass() {
		return AnuncioMultipleLocalizado.class;
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
		
		anuncio.insert();
		anuncio.getPersistenceManager().save(anuncio);
		for (Direccion direccion : addresses) {
			direccion.owner = anuncio;
			PersistenceManagerFactory.getPersistenceManager(Direccion.class).save(direccion);
		}
	}	
	
	@Transactional
	public void delete(AnuncioMultipleLocalizado anuncio){
		List<Direccion> direcciones = anuncio.getListaDirecciones().fetch();
		PersistenceManagerFactory.getPersistenceManager(Direccion.class).delete(direcciones);
		
		anuncio.delete();
	}
	

}
