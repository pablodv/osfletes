package com.osfletes.web.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.osfletes.web.dto.ContractDTO;

public class ContractValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return ContractValidator.class.equals(arg0);
	}

	@Override
	public void validate(Object arg0, Errors e) {
		ContractDTO contractDto = (ContractDTO) arg0;
		if(contractDto.getAnnouncementDTO().getId() == null && !e.hasFieldErrors("announcementId")){
			e.rejectValue("announcementDTO.id", "contract.empty.announcment");
		}
		
		if(contractDto.getOfferDTO().getId() == null && !e.hasFieldErrors("offerId")){
			e.rejectValue("offerDTO.id", "contract.empty.offer");
		}
	}

}
