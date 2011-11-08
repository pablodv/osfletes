package com.osfletes.model;

import java.util.Date;

import siena.Column;
import siena.DateTime;
import siena.Generator;
import siena.Id;
import siena.Index;
import siena.Model;
import siena.NotNull;
import siena.Query;
import siena.Table;

@Table("anuncios")
public class Anuncio extends Model{
	
	@Index(value = { "anuncio_index" })
	@Id(Generator.AUTO_INCREMENT)
	public Long id;
	
	@DateTime
    @Column("fecha_desde")
    @NotNull	
	public Date fechaDesde;

	@DateTime
    @Column("fecha_hasta")
    @NotNull	
	public Date fechaHasta;
    
	@DateTime
    @Column("fecha_creacion")
    @NotNull	
	public Date fechaCreacion;
    
	@DateTime
    @Column("fecha_cierre")
    @NotNull	
	public Date fechaCierre;
    
    @Column("hora_desde")
	public Integer horaDesde;
    
    @Column("hora_hasta")
	public Integer horaHasta;
    
    @Index("user_index")
    @Column("user_id")
    public User user;
    
	
    static Query<Anuncio> all() {
        return Model.all(Anuncio.class);
    }
 
    public static Anuncio findById(Long id) {
        return all().filter("id", id).get();
    }
    
	
}
