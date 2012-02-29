package com.osfletes.model;

import javax.persistence.Entity;

import com.osfletes.security.User;

@Entity(name="CLIENTE")
public class Cliente extends User{
	
	private static final long serialVersionUID = 676773547191009733L;
}
