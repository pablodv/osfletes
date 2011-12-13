package com.osfletes.security;

import org.springframework.security.core.GrantedAuthority;


public class Role implements GrantedAuthority {

	
	public Long id;
	
	public String role;

    
	public User user;
	
	@Override
	public String getAuthority() {
		return role;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	

}
