package com.osfletes.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.osfletes.model.Anuncio;

@Service(value="anuncioService")
public class AnuncioService extends GenericSienaServiceImpl<Anuncio> implements IAnuncioService{

	@Override
	protected Class<Anuncio> getRepresentedClass() {
		return Anuncio.class;
	}

	@Override
	@Transactional
	public void saveRollback(Anuncio obj) {
		obj.insert();
		obj.getPersistenceManager().save(obj);
		throw new RuntimeException();
	}

	

}
