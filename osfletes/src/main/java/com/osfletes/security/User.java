package com.osfletes.security;

import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.osfletes.model.hibernate.ObjetoPersistente;

@Entity(name="USER")
@Inheritance(strategy=InheritanceType.JOINED)
public class User extends ObjetoPersistente implements UserDetails {

	private static final long serialVersionUID = 4079664434226649300L;
	
	public String password;
	
    public String username;
	
    @ManyToMany(targetEntity=Role.class,fetch=FetchType.LAZY)
	  @Cascade(value={CascadeType.DELETE_ORPHAN,CascadeType.PERSIST, CascadeType.SAVE_UPDATE})
	  @JoinTable(
	       name="USER_ROLE",
	       joinColumns=@JoinColumn(name="USER_ID"),
	       inverseJoinColumns=@JoinColumn(name="ROLE_ID"))
	private Collection<GrantedAuthority> authorities;
	
	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		return authorities;
	}

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
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		return true;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setAuthorities(Collection<GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	
}
