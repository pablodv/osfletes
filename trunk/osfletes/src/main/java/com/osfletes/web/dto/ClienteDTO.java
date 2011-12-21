package com.osfletes.web.dto;

import java.util.ArrayList;
import java.util.List;

public class ClienteDTO {
	private Long id;
	private String password;
	private String username;

	private List<AnuncioMultipleDTO> listaAnuncios;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<AnuncioMultipleDTO> getListaAnuncios() {
		if(listaAnuncios == null){
			listaAnuncios = new ArrayList<AnuncioMultipleDTO>();
		}
		return listaAnuncios;
	}

	public void setListaAnuncios(List<AnuncioMultipleDTO> listaAnuncios) {
		this.listaAnuncios = listaAnuncios;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
