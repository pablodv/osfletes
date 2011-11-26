package com.osfletes.web.validator;

import java.util.HashMap;
import java.util.Map;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ValidatorFactory implements Validator {

	
	private Map<Class<?>,Validator> validators = new HashMap<Class<?>,Validator>();
	
	
	@Override
	public boolean supports(Class<?> clazz) {
		return validators.containsKey(clazz);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		validators.get(arg0.getClass()).validate(arg0, arg1);	
	}

	public Map<Class<?>, Validator> getValidators() {
		return validators;
	}

	public void setValidators(Map<Class<?>, Validator> validators) {
		this.validators = validators;
	}
	
	


}
