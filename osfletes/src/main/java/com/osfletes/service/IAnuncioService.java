package com.osfletes.service;

import com.osfletes.model.AnuncioMultipleLocalizado;

public interface IAnuncioService extends IService<AnuncioMultipleLocalizado> {
	
	public void saveRollback(AnuncioMultipleLocalizado obj);

}
