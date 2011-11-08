package com.osfletes.model;

import org.springframework.security.core.GrantedAuthority;

import siena.Column;
import siena.Generator;
import siena.Id;
import siena.Model;


public class Role extends Model implements GrantedAuthority {

	@Id(Generator.AUTO_INCREMENT)
	public Long id;
	
	public String role;

    @Column("user_id")
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
