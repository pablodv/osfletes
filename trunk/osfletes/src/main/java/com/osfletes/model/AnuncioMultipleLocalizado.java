package com.osfletes.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity(name="ANUNCIO_MULTIPLE")
public class AnuncioMultipleLocalizado extends Anuncio{
	
	private static final long serialVersionUID = 1367436832646814145L;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="ANUNCIO_ID")
	private List<Direccion> listaDirecciones;
	
	public List<Direccion> getListaDirecciones() {
		if(this.listaDirecciones == null){
			listaDirecciones = new ArrayList<Direccion>();
		}
		return listaDirecciones;
	}

	public void setListaDirecciones(List<Direccion> listaDirecciones) {
		this.listaDirecciones = listaDirecciones;
	}	
}
