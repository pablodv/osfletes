package com.osfletes.quartz;

import java.util.Calendar;
import java.util.List;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.StatefulJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.osfletes.model.AnuncioMultipleLocalizado;
import com.osfletes.service.interfaces.IAnuncioService;
import com.osfletes.web.dto.FiltroAnuncioDTO;
import com.osfletes.web.model.ResultadoPaginado;


public class ProcesarAnunciosVencidosJob extends QuartzJobBean implements StatefulJob{
	
	private IAnuncioService anuncioService;
	
	public void execute(){
	}

	public IAnuncioService getAnuncioService() {
		return anuncioService;
	}

	@Autowired
	public void setAnuncioService(IAnuncioService anuncioService) {
		this.anuncioService = anuncioService;
	}

	@Override
	protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
		System.out.println("procesando anuncios ....");
		
		FiltroAnuncioDTO filtroDTO = new FiltroAnuncioDTO();
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH, -1);
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		
		
		filtroDTO.setFechaHasta(cal.getTime());
		
		ResultadoPaginado<AnuncioMultipleLocalizado> anuncios = anuncioService.findAnuncios(filtroDTO);
		
		List<AnuncioMultipleLocalizado> lista = anuncios.getResultados();
		
		
		try{
			
			for (AnuncioMultipleLocalizado anuncioMultipleLocalizado : lista) {
				//anuncioMultipleLocalizado.setVencido(true);
				anuncioService.update(anuncioMultipleLocalizado);
			}
		
		}catch (Exception e) {
			e.printStackTrace(); 
			
		}
	}
	
}
