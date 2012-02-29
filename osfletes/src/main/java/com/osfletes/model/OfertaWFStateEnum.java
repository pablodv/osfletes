package com.osfletes.model;

public enum OfertaWFStateEnum {
	CREADO("creado"),
	ADJUDICADA("ADJUDICADA"),
	NO_ADJUDICADA("NO ADJUDICADA"),
	CANCELADA_POR_PROVEEDOR("CANCELADA POR PROVEEDOR"),
	CANCELADA_POR_ANUNCIO_CANCELADO("CANCELADA POR ANUNCIO CANCELADO");
	
	private String name;
   
	OfertaWFStateEnum(String name){
  	 this.name = name;
   }
   
   public String getName(){
  	 return this.name;
   }
}
