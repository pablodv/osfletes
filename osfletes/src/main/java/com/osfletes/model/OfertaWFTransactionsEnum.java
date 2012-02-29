package com.osfletes.model;

public enum OfertaWFTransactionsEnum {
	CLIENTE_SELECCIONA_OFERTA("CLIENTE SELECCIONA OFERTA"),
	CLIENTE_NO_SELECCIONA_OFERTA("CLIENTE NO SELECCIONA OFERTA"),
	CANCELAR_OFERTA_POR_ANUNCIO_CANCELADO("CANCELAR_OFERTA_POR_ANUNCIO_CANCELADO"),
	PROVEEDOR_CANCELA_OFERTA("PROVEEDOR CANCELA OFERTA");
	private String name;
   
	OfertaWFTransactionsEnum(String name){
  	 this.name = name;
   }
   
   public String getName(){
  	 return this.name;
   }
}
