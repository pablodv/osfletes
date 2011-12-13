package com.osfletes.model;

import java.math.BigDecimal;

import javax.persistence.Transient;

import com.osfletes.model.hibernate.ObjetoPersistente;

public class Direccion extends ObjetoPersistente {
	
	

    	
	public String direccion;
    
   
	public BigDecimal longitud;
    
    	
	public BigDecimal latitud;
    
    public Integer posicion;
    
    @Transient
	public AnuncioMultipleLocalizado owner;
}
