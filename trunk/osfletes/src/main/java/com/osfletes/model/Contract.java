package com.osfletes.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.licitaciones.StateAware;
import com.osfletes.model.hibernate.ObjetoPersistente;

@Entity(name="CONTRACT")
public class Contract extends ObjetoPersistente implements StateAware {

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="announcement_id")
	private Anuncio announcement;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="offer_id")
	private Oferta offer;
	
	@Column(name="ESTADO")
	private int state;

	public Anuncio getAnnouncement() {
		return announcement;
	}

	public void setAnnouncement(Anuncio announcement) {
		this.announcement = announcement;
	}

	public Oferta getOffer() {
		return offer;
	}

	public void setOffer(Oferta offer) {
		this.offer = offer;
	}

	@Override
	public void setState(int stateId) {
		this.state = stateId;
	}

	@Override
	public int getState() {
		return this.state;
	}
}
