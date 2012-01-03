package com.osfletes.quartz;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.osfletes.model.AnuncioMultipleLocalizado;
import com.osfletes.service.interfaces.IAnuncioService;
import com.osfletes.web.dto.FiltroDTO;


public class ProcesarAnunciosVencidosJob{
	
	@Autowired
	private IAnuncioService anuncioService;
	
	public void execute(){
		System.out.println("procesando anuncios ....");
		
		FiltroDTO filtroDTO = new FiltroDTO();
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH, -1);
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		
		
		filtroDTO.setFechaHasta(cal.getTime());
		
		List<AnuncioMultipleLocalizado> lista = getAnuncioService().findAnuncios(filtroDTO);
		
		for (AnuncioMultipleLocalizado anuncioMultipleLocalizado : lista) {
			anuncioMultipleLocalizado.setVencido(true);
			anuncioService.saveOrUpdate(anuncioMultipleLocalizado);
		}
	}

	public IAnuncioService getAnuncioService() {
		return anuncioService;
	}

	public void setAnuncioService(IAnuncioService anuncioService) {
		this.anuncioService = anuncioService;
	}
	
}
