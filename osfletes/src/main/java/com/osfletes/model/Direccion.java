package com.osfletes.model;

import java.math.BigDecimal;

import siena.Column;
import siena.Generator;
import siena.Id;
import siena.Index;
import siena.Model;
import siena.NotNull;
import siena.Table;

@Table("direccion")
public class Direccion extends Model{
	@Index(value = { "direccion_index" })
	@Id(Generator.AUTO_INCREMENT)
	public Long id;

    @Column("direccion")
    @NotNull	
	public String direccion;
    
    @Column("longitud")
    @NotNull	
	public BigDecimal longitud;
    
    @Column("latitud")
    @NotNull	
	public BigDecimal latitud;
    
    public Integer posicion;
    
    @Column("owner")
	public AnuncioMultipleLocalizado anuncio;
}
