package com.osfletes.model;

import siena.core.Many;
import siena.core.Owned;

public class AnuncioMultipleLocalizado extends Anuncio{

	@Owned
	public Many<Direccion> listaDirecciones;
}
