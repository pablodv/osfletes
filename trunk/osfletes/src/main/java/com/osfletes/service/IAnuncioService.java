package com.osfletes.service;

import com.osfletes.model.Anuncio;

public interface IAnuncioService extends IService<Anuncio> {
	
	public void saveRollback(Anuncio obj);

}
