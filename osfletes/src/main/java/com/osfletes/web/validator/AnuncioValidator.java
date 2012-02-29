package com.osfletes.web.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.osfletes.web.dto.AnuncioDTO;

public class AnuncioValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return AnuncioDTO.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors e) {
		AnuncioDTO anuncio = (AnuncioDTO) obj;
		ValidationUtils.rejectIfEmpty(e, "horaDesde", "field.empty");
		if(anuncio.getHoraDesde() == null && !e.hasFieldErrors("horaDesde")){
			e.rejectValue("horaDesde", "field.empty");
		}
		if(anuncio.getHoraHasta() == null && !e.hasFieldErrors("horaHasta")){
			e.rejectValue("horaHasta", "field.empty");
		}
		if(anuncio.getFechaDesde() == null && !e.hasFieldErrors("fechaDesde")){
			e.rejectValue("fechaDesde", "field.empty");
		}
		if(anuncio.getFechaHasta() == null && !e.hasFieldErrors("fechaHasta")){
			e.rejectValue("fechaHasta", "field.empty");
		}
				
	}

}
