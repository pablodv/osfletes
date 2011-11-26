package com.osfletes.web.exception.handler;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;






public class ExceptionHandler implements HandlerExceptionResolver {

	@Override
	public org.springframework.web.servlet.ModelAndView resolveException(
			HttpServletRequest arg0, HttpServletResponse arg1, Object arg2,
			Exception arg3) {
		
		Errors e = new BeanPropertyBindingResult(arg2,"null");
		return new ModelAndView();
	}

	


}
