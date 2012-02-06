package com.osfletes.web.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.NoSuchMessageException;

public class JsonMesagesResolver {

	@Autowired
	private MessageSource messageSource;
	private static JsonMesagesResolver INSTANCE;
	
	 // constructor privado
	  private JsonMesagesResolver() {/*Singleton*/}

	  public static JsonMesagesResolver getInstance() {
	    if (INSTANCE == null) {
	      INSTANCE = new JsonMesagesResolver();
	    }
	    return INSTANCE;
	  }
	
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	

	public static String getMessage(MessageSourceResolvable arg0, Locale arg1)	throws NoSuchMessageException {
		return INSTANCE.messageSource.getMessage(arg0, arg1);
	}

	public static String getMessage(String arg0, Object[] arg1, Locale arg2)throws NoSuchMessageException {
		return INSTANCE.messageSource.getMessage(arg0, arg1, arg2);
	}

	public static String getMessage(String arg0, Object[] arg1, String arg2,Locale arg3) {
		return INSTANCE.messageSource.getMessage(arg0, arg1, arg2, arg3);
	}
}
