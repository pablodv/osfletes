package com.osfletes.web.validator;

import java.math.BigDecimal;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.osfletes.web.dto.OfertaDTO;

public class OfertaValidator implements Validator{

	

	
	@Override
	public boolean supports(Class<?> clazz) {
		return OfertaDTO.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors e) {
		OfertaDTO oferta = (OfertaDTO) obj;
		
		if(oferta.getValue() == null && !e.hasFieldErrors("valorOferta")){
			e.rejectValue("value", "field.empty");
		}
		
		if(oferta.getValue() != null && !e.hasFieldErrors("valorOferta") && oferta.getValue().compareTo(new BigDecimal(0)) <= 0 ){
			e.rejectValue("value", "field.invalid-range");
		}
		
		if(oferta.getAnnouncementId() == null && !e.hasFieldErrors("announcementId")){
			e.rejectValue("announcementId", "field.empty");
		}
		

		if(oferta.getServiceDate() == null && !e.hasFieldErrors("fechaServicio")){
			e.rejectValue("serviceDate", "field.empty");
		}
	}

}
