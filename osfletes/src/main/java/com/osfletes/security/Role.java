package com.osfletes.security;

import javax.persistence.Entity;

import org.springframework.security.core.GrantedAuthority;

import com.osfletes.model.hibernate.ObjetoPersistente;

@Entity
public class Role extends ObjetoPersistente implements GrantedAuthority {

	
	public String role;

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
