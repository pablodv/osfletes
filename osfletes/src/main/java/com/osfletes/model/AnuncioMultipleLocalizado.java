package com.osfletes.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity(name="anuncioMultipeLocalizado")
public class AnuncioMultipleLocalizado extends Anuncio{
	
	private static final long serialVersionUID = 1367436832646814145L;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="ANUNCIO_ID")
	private List<Direccion> listaDirecciones;
	
	@Column(name="Vencido")
	private Boolean vencido = false;

	public List<Direccion> getListaDirecciones() {
		if(this.listaDirecciones == null){
			listaDirecciones = new ArrayList<Direccion>();
		}
		return listaDirecciones;
	}

	public void setListaDirecciones(List<Direccion> listaDirecciones) {
		this.listaDirecciones = listaDirecciones;
	}

	public Boolean getVencido() {
		return vencido;
	}

	public void setVencido(Boolean vencido) {
		this.vencido = vencido;
	}
	
}
