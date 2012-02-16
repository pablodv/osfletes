package com.osfletes.model;

public enum AnuncioWFStateEnum {
	CREADO("creado"),
	PUBLICADO("publicado"),
	PUBLICACION_CERRADA("publicacion cerrada"),
	CANCELADA("cancelado"),
	PROVEEDOR_SELECCIONADO("proveedor seleccionado"),
	CERRAR_SIN_ADJUDICACION("cerrado sin adjudicacion"),
	ELIMINADO("eliminado");
	
	private String name;
   
	 AnuncioWFStateEnum(String name){
  	 this.name = name;
   }
   
   public String getName(){
  	 return this.name;
   }
}
