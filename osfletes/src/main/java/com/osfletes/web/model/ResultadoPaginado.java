package com.osfletes.web.model;

import java.util.List;

public class ResultadoPaginado<T> {

	List<T> resultados;
	Integer pagina;
	Integer cantidad;
	
	public List<T> getResultados() {
		return resultados;
	}
	public void setResultados(List<T> resultados) {
		this.resultados = resultados;
	}
	public Integer getPagina() {
		return pagina;
	}
	public void setPagina(Integer pagina) {
		this.pagina = pagina;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	
}
