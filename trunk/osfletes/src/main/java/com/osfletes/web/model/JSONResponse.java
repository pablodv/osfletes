package com.osfletes.web.model;

import java.util.List;

import org.springframework.validation.ObjectError;

public class JSONResponse {
	private boolean success = true;
	private List<ObjectError> errors;
	private Object response;
	private String message;
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public List<ObjectError> getErrors() {
		return errors;
	}
	public void setErrors(List<ObjectError> errors) {
		this.errors = errors;
	}
	public Object getResponse() {
		return response;
	}
	public void setResponse(Object response) {
		this.response = response;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
