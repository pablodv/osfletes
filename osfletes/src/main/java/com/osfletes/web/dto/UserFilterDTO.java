package com.osfletes.web.dto;

public class UserFilterDTO extends GenericFilterDTO {

	private Boolean enable;
	private String username;
	
	
	
	public Boolean getEnable() {
		return enable;
	}
	public void setEnable(Boolean enable) {
		this.enable = enable;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
