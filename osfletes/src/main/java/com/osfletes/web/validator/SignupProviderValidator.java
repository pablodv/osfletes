package com.osfletes.web.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.osfletes.service.ServiceLocator;
import com.osfletes.web.dto.SignupClientDTO;
import com.osfletes.web.dto.SignupProviderDTO;

public class SignupProviderValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return SignupProviderDTO.class.equals(arg0);
	}

	@Override
	public void validate(Object arg0, Errors e) {
		SignupClientDTO signupClient = (SignupClientDTO) arg0;
		if(ServiceLocator.getProviderService().existUserWithMail(signupClient.getMail())){
			e.rejectValue("mail", "username.not.available");
		}
				
	}

}
