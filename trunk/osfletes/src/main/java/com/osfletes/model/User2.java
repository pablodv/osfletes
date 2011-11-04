package com.osfletes.model;

import siena.Column;
import siena.Filter;
import siena.Generator;
import siena.Id;
import siena.Index;
import siena.Model;
import siena.NotNull;
import siena.Query;
import siena.Table;

@Table("usuarios2")
public class User2 extends Model{
	
	@Index(value = { "usuario2_index" })
	@Id(Generator.AUTO_INCREMENT)
	public Long id;
	
    @Column("nombre")
    @NotNull	
	public String nombre;
    
    @Column("apellido")
    @NotNull	
    public String apellido;
    
    @Column("email")
    @NotNull	
	public String email;
    
    @Column("username")
    @NotNull	
	public String username;
    
    @Column("password")
    @NotNull	
	public String password;
    
    @Filter("user")
    public Query<Anuncio> anuncios;
	
}
