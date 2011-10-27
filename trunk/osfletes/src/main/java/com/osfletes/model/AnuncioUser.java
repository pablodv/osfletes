package com.osfletes.model;

import siena.Column;
import siena.Id;
import siena.Index;
import siena.NotNull;

public class AnuncioUser {
	@Id
	public Long id;

    @NotNull
    @Column("user_id")
    @Index("user_index")
    public User user;
    
    @NotNull
    @Column("anuncio_id")
    @Index("anuncio_index")
	public Anuncio anuncio;
}
