package com.osfletes.service;

import java.util.List;

import com.osfletes.model.AnuncioMultipleLocalizado;
import com.osfletes.model.Direccion;

public interface IAnuncioService extends IService<AnuncioMultipleLocalizado> {
	
	public void saveRollback(AnuncioMultipleLocalizado obj);
	public void saveWithAddresses(AnuncioMultipleLocalizado anuncio,List<Direccion> addresses);

}
