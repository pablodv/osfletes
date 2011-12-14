package com.osfletes.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

import com.osfletes.security.User;

@Entity(name="PROVEEDOR")
@PrimaryKeyJoinColumn(name="USER_ID")
public class Proveedor extends User{
	
	private static final long serialVersionUID = 2834989615724331733L;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="PROVEEDOR_ID")
	private List<Oferta> listaOfertas;

	public List<Oferta> getListaOfertas() {
		return listaOfertas;
	}

	public void setListaOfertas(List<Oferta> listaOfertas) {
		this.listaOfertas = listaOfertas;
	}
	
	
}
