package com.osfletes.web.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
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
		ValidationUtils.rejectIfEmpty(e, "valorOferta", "field.empty","gggggggggggggggggggggggggggggggggggg");		
	}

}
