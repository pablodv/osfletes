package com.osfletes.security;

public enum RolesEnum {
     ROL_ADMIN("ROL_ADMIN"),ROL_CLIENTE("ROL_CLIENTE"),ROL_PROVEEDOR("ROL_PROVEEDOR");
     
     private String rol;
     
     RolesEnum(String rol){
    	 this.rol = rol;
     }
     
     public String getRolName(){
    	 return this.rol;
     }
}
