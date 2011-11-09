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
	public Date fechaDesde;

	@DateTime
    @Column("fecha_hasta")
	public Date fechaHasta;
    
	@DateTime
    @Column("fecha_creacion")
	public Date fechaCreacion;
    
	@DateTime
    @Column("fecha_cierre")
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFechaDesde() {
		return fechaDesde;
	}

	public void setFechaDesde(Date fechaDesde) {
		this.fechaDesde = fechaDesde;
	}

	public Date getFechaHasta() {
		return fechaHasta;
	}

	public void setFechaHasta(Date fechaHasta) {
		this.fechaHasta = fechaHasta;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaCierre() {
		return fechaCierre;
	}

	public void setFechaCierre(Date fechaCierre) {
		this.fechaCierre = fechaCierre;
	}

	public Integer getHoraDesde() {
		return horaDesde;
	}

	public void setHoraDesde(Integer horaDesde) {
		this.horaDesde = horaDesde;
	}

	public Integer getHoraHasta() {
		return horaHasta;
	}

	public void setHoraHasta(Integer horaHasta) {
		this.horaHasta = horaHasta;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
    
	
}
