package com.osfletes.model;

import java.util.Date;

import siena.Column;
import siena.Generator;
import siena.Id;
import siena.Model;
import siena.NotNull;
import siena.Query;
import siena.Table;

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
    
    //@Index("user_index")
    @Column("user")
    public User user;
	
    static Query<Anuncio> all() {
        return Model.all(Anuncio.class);
    }
 
    public static Anuncio findById(Long id) {
        return all().filter("id", id).get();
    }
    
	
}
