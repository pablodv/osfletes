package com.osfletes.model;

import java.util.Date;


import siena.Column;
import siena.Generator;
import siena.Id;
import siena.Model;
import siena.NotNull;
import siena.Table;
import siena.Index;

@Table("anuncios")
public class Anuncio extends Model{
	@Id(Generator.AUTO_INCREMENT)
	public Long id;
	
    @Column("fecha_desde")
    @NotNull	
	public Date fechaDesde;

    @Column("fecha_hasta")
    @NotNull	
	public Date fechaHasta;
    
    @Column("fecha_creacion")
    @NotNull	
	public Date fechaCreacion;
    
    @Column("fecha_cierre")
    @NotNull	
	public Date fechaCierre;
    
    @Column("hora_desde")
	public Integer horaDesde;
    
    @Column("fecha_hasta")
	public Integer horaHasta;
    
    @Index("user_index")
	public User user;
	
	
}
