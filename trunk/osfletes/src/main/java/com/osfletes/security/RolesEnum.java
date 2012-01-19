package com.osfletes.security;

public enum RolesEnum {
     ROLE_ADMIN("ROLE_ADMIN"),ROLE_CLIENT("ROLE_CLIENT"),ROLE_PROV("ROLE_PROV");
     
     private String rol;
     
     RolesEnum(String rol){
    	 this.rol = rol;
     }
     
     public String getRolName(){
    	 return this.rol;
     }
}
