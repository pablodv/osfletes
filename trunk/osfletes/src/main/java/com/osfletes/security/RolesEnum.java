package com.osfletes.security;

public enum RolesEnum {
     ROL_ADMIN("ROL_ADMIN"),ROL_CLIENT("ROL_CLIENT"),ROL_PROV("ROL_PROV");
     
     private String rol;
     
     RolesEnum(String rol){
    	 this.rol = rol;
     }
     
     public String getRolName(){
    	 return this.rol;
     }
}
