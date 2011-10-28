package com.osfletes.service;

import java.util.List;

import com.osfletes.model.Anuncio;

public class AnuncioService implements IService<Anuncio>{

	@Override
	public void save(Anuncio obj) {
		obj.insert();
		
	}

	@Override
	public List<Anuncio> list() {

		return Anuncio.all(Anuncio.class).fetch();
	}

	@Override
	public void delete(Anuncio obj) {
		// TODO Auto-generated method stub
		
	}

}
