package com.osfletes.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity(name="CLIENTE")
@PrimaryKeyJoinColumn(name="USER_ID")
public class Cliente {
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="CLIENTE_ID")
	private List<? extends Anuncio> listaAnuncios;

	public List<? extends Anuncio> getListaAnuncios() {
		return listaAnuncios;
	}

	public void setListaAnuncios(List<? extends Anuncio> listaAnuncios) {
		this.listaAnuncios = listaAnuncios;
	}
}
