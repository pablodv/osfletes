package com.osfletes.web.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.osfletes.web.dto.OfertaDTO;
import com.osfletes.web.dto.RoleDTO;

public class RoleValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		return OfertaDTO.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors e) {
		RoleDTO role = (RoleDTO) obj;
		if((role.getRole() == null || role.getRole().trim().isEmpty()) && !e.hasFieldErrors("role"))
			e.rejectValue("role", "field.empty");		
	}

}
