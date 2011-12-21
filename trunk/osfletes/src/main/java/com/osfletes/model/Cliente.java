package com.osfletes.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

import com.osfletes.security.User;

@Entity(name="CLIENTE")
@PrimaryKeyJoinColumn(name="USER_ID")
public class Cliente extends User{
	
	private static final long serialVersionUID = 676773547191009733L;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="CLIENTE_ID")
	private List<AnuncioMultipleLocalizado> listaAnuncios;

	public List<AnuncioMultipleLocalizado> getListaAnuncios() {
		return listaAnuncios;
	}

	public void setListaAnuncios(List<AnuncioMultipleLocalizado> listaAnuncios) {
		this.listaAnuncios = listaAnuncios;
	}
}
