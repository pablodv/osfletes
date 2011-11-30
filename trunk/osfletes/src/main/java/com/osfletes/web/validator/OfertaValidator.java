package com.osfletes.web.validator;

import java.math.BigDecimal;

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
		ValidationUtils.rejectIfEmpty(e, "valorOferta", "field.empty");
		if(oferta.getValorOferta() == null && !e.hasFieldErrors("valorOferta")){
			e.rejectValue("valorOferta", "field.empty");
		}
		
		if(oferta.getValorOferta() != null && !e.hasFieldErrors("valorOferta") && oferta.getValorOferta().compareTo(new BigDecimal(0)) <= 0 ){
			e.rejectValue("valorOferta", "field.invalid-range");
		}
		
//		if(oferta.getAnuncioId() == null){
//			e.rejectValue("anuncioId", "field.empty");
//		}
		
		if(oferta.getFechaServicio() == null && !e.hasFieldErrors("fechaServicio")){
			e.rejectValue("fechaServicio", "field.empty");
		}
	}

}
