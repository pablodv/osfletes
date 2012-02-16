package com.osfletes.web.dto;

public class GenericFilterDTO {
	private Long usuarioCreacion;
	private Integer pageSize = 50;
	private Integer pagina = 1;
	
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getPage() {
		return pagina;
	}
	public void setPagina(Integer pagina) {
		this.pagina = pagina;
	}
	public Long getUsuarioCreacion() {
		return usuarioCreacion;
	}
	public void setUsuarioCreacion(Long usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}
	
	
}
