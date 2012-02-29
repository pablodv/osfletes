package com.osfletes.mapper;

import java.util.List;

import com.osfletes.model.Anuncio;
import com.osfletes.model.Contract;
import com.osfletes.model.Oferta;
import com.osfletes.service.ServiceLocator;
import com.osfletes.web.dto.ContractDTO;

public class ContractMapper implements IMapper<Contract, ContractDTO> {

	
	public ContractDTO toDTO(Contract model) {
		return null;
	}

	public Contract toModel(ContractDTO dto) {
		Anuncio announcement = ServiceLocator.getAnuncioService().getById(dto.getAnnouncementDTO().getId());
		Oferta offer = ServiceLocator.getOfertaService().getById(dto.getOfferDTO().getId());
		
		Contract contract = new Contract();
		contract.setAnnouncement(announcement);
		contract.setOffer(offer);
		return contract;
	}

	
	public List<ContractDTO> listToDto(List<Contract> lista) {
		// TODO Auto-generated method stub
		return null;
	}

}
