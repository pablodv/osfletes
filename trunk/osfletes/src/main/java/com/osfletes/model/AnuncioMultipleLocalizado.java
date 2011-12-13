package com.osfletes.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity(name="anuncioMultipeLocalizado")
public class AnuncioMultipleLocalizado extends Anuncio{
	
	private static final long serialVersionUID = 1367436832646814145L;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="anuncio_id")
	public List<Direccion> listaDirecciones;

	public List<Direccion> getListaDirecciones() {
		return listaDirecciones;
	}

	public void setListaDirecciones(List<Direccion> listaDirecciones) {
		this.listaDirecciones = listaDirecciones;
	}
	
}
