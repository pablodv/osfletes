package com.osfletes.model;

import siena.Filter;
import siena.Query;

public class AnuncioMultipleLocalizado extends Anuncio{

	//@Owned
	//public Many<Direccion> listaDirecciones;
	
	@Filter("owner")
	public Query<Direccion> listaDirecciones;
}
