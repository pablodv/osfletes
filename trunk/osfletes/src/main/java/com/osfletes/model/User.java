package com.osfletes.model;




import java.util.Collection;

import javax.persistence.Entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import siena.Column;
import siena.Filter;
import siena.Generator;
import siena.Id;
import siena.Index;
import siena.Model;
import siena.NotNull;
import siena.Query;
import siena.Table;


@Table("users")
@Entity(name="PROP_USERS")
public class User extends Model implements UserDetails {

	private static final long serialVersionUID = 4079664434226649300L;
	
	@Index(value = { "user_index" })
	@Id(Generator.AUTO_INCREMENT)
	public Long id;

	@Column("password")
    @NotNull	
	public String password;
	
    @Column("username")
    @NotNull	
	public String username;
	
    //@OneToMany
	//public Collection<GrantedAuthority> authorities;
    
	@Filter("owner")
	public Query<Direccion> authorities;
    

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


	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
