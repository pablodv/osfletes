package com.osfletes.security;




import java.util.Collection;

import javax.persistence.Entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


@Entity(name="PROP_USERS")
public class User implements UserDetails {

	private static final long serialVersionUID = 4079664434226649300L;
	
	public Long id;

	public String password;
	
    public String username;
	
    @Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUsername(String username) {
		this.username = username;
	}


	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		return null;
	}

	
}
