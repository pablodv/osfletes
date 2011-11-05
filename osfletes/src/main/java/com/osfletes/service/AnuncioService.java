package com.osfletes.service;

import java.util.List;

import org.springframework.stereotype.Service;

import siena.Model;

import com.osfletes.model.Anuncio;

@Service(value="AnuncioService")
public class AnuncioService implements IService<Anuncio>{

	@Override
	public void save(Anuncio obj) {
		obj.insert();
		obj.getPersistenceManager().beginTransaction();
			obj.getPersistenceManager().save(obj);
		obj.getPersistenceManager().commitTransaction();
	}
	
	public void rollbackSave(Anuncio obj) {
		obj.insert();
		obj.getPersistenceManager().beginTransaction();
		obj.getPersistenceManager().save(obj);
		obj.getPersistenceManager().rollbackTransaction();
		
	}

	@Override
	public List<Anuncio> list() {

		return Model.all(Anuncio.class).fetch();
	}

	@Override
	public void delete(Anuncio obj) {
		// TODO Auto-generated method stub
		
	}

}
