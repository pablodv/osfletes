package com.osfletes.model;

import siena.Filter;
import siena.Query;

public class AnuncioMultipleLocalizado extends Anuncio{

	//@Owned
	//public Many<Direccion> listaDirecciones;
	
	@Filter("owner")
	public Query<Direccion> listaDirecciones;

	public Query<Direccion> getListaDirecciones() {
		return listaDirecciones;
	}

	public void setListaDirecciones(Query<Direccion> listaDirecciones) {
		this.listaDirecciones = listaDirecciones;
	}
	
	
}
