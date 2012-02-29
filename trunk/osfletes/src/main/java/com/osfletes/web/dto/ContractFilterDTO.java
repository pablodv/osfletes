package com.osfletes.web.dto;

public class ContractFilterDTO extends GenericFilterDTO {

	private Long proveedor;
	
	public void setProveedor(Long proveedor) {
		this.proveedor = proveedor;
		
	}

	public Long getProveedor() {
		return proveedor;
	}
	
	

}
