package com.osfletes.model;

public enum AnuncioWFTransactionsEnum {
	CREAR("crear"),PUBLICAR("publicar"),CERRAR("cerrar"),CANCELAR("cancelar"),SELECCIONAR("seleccionar"),TERMINAR_VENCIDO("terminar-vencido"),ELIMINAR("eliminar");
	
	 private String name;
    
	AnuncioWFTransactionsEnum(String name){
   	 this.name = name;
    }
    
    public String getName(){
   	 return this.name;
    }
	
}
