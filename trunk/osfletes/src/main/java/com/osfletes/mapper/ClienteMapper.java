package com.osfletes.mapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.osfletes.model.Cliente;
import com.osfletes.web.dto.ClienteDTO;

public class ClienteMapper implements IMapper<Cliente,ClienteDTO>{

	@Autowired
	private AnuncioMultipleMapper anuncioMultipleMapper;
	
	@Override
	public ClienteDTO toDTO(Cliente model) {
		ClienteDTO dto = new ClienteDTO();
		dto.setUsername(model.getUsername());
		dto.setPassword(model.getPassword());
		dto.setId(model.getId());
		
		return dto;
	}

	@Override
	public Cliente toModel(ClienteDTO dto) {
		Cliente cliente = new Cliente();
		
		cliente.setUsername(dto.getUsername());
		cliente.setPassword(dto.getPassword());
		
		return null;
	}

	public AnuncioMultipleMapper getAnuncioMultipleMapper() {
		return anuncioMultipleMapper;
	}

	public void setAnuncioMultipleMapper(AnuncioMultipleMapper anuncioMultipleMapper) {
		this.anuncioMultipleMapper = anuncioMultipleMapper;
	}

	@Override
	public List<ClienteDTO> listToDto(List<Cliente> lista) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
