package com.osfletes.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.osfletes.model.Anuncio;
import com.osfletes.model.AnuncioMultipleLocalizado;

@Service(value="anuncioService")
public class AnuncioService extends GenericSienaServiceImpl<AnuncioMultipleLocalizado> implements IAnuncioService{

	@Override
	protected Class<AnuncioMultipleLocalizado> getRepresentedClass() {
		return AnuncioMultipleLocalizado.class;
	}

	@Override
	@Transactional
	public void saveRollback(Anuncio obj) {
		obj.insert();
		obj.getPersistenceManager().save(obj);
		throw new RuntimeException();
	}

	

}
