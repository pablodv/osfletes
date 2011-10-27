package com.osfletes.model;

import siena.Id;

public class AnuncioUser {
	@Id
	public Long id;
	public User user;
	public Anuncio anuncio;
}
