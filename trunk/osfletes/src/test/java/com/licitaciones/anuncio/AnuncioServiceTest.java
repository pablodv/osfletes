package com.licitaciones.anuncio;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.osfletes.mapper.AnuncioMultipleMapper;
import com.osfletes.mapper.DireccionMapper;
import com.osfletes.model.AnuncioMultipleLocalizado;
import com.osfletes.service.interfaces.IAnuncioService;
import com.osfletes.web.dto.AnuncioMultipleDTO;
import com.osfletes.web.dto.FiltroDTO;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/AnuncioServiceTest-context.xml"})
public class AnuncioServiceTest {
	
	
	@Autowired
	protected IAnuncioService anuncioService;
	
	@Autowired
	private AnuncioMultipleMapper anuncioMultipleMapper;

	@Autowired
	private DireccionMapper direccionMapper;
	
	@Test
	public void saveDummy(){
		
		AnuncioMultipleDTO anuncioMultipleDTO = new AnuncioMultipleDTO();
		
		anuncioMultipleDTO.setDescripcion("desc 1");
		anuncioMultipleDTO.setDireccion1("direccion 1");
		anuncioMultipleDTO.setDireccion2("direccion 2");
		anuncioMultipleDTO.setFechaCierre(new Date());
		anuncioMultipleDTO.setFechaCreacion(new Date());
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, 2000);
		calendar.set(Calendar.MONTH, 0);//enero
		calendar.set(Calendar.DAY_OF_MONTH,5);
		
		anuncioMultipleDTO.setFechaDesde(calendar.getTime());
		calendar.set(Calendar.YEAR, 2010);
		calendar.set(Calendar.MONTH, 0);//enero
		calendar.set(Calendar.DAY_OF_MONTH,1);
		
		
		anuncioMultipleDTO.setFechaHasta(calendar.getTime());
		anuncioMultipleDTO.setHoraDesde(1);
		anuncioMultipleDTO.setHoraHasta(2);
		
		AnuncioMultipleLocalizado anuncio;
		
		anuncio = anuncioMultipleMapper.toModel(anuncioMultipleDTO);
		
		anuncioService.save(anuncio);
	}

	@Test
	public void testFindFechas(){
		FiltroDTO filtro = new FiltroDTO();
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, 2000);
		calendar.set(Calendar.MONTH, 0);//enero
		calendar.set(Calendar.DAY_OF_MONTH,1);
		
		filtro.setFechaDesde(calendar.getTime());
		
		calendar.set(Calendar.YEAR, 2011);
		calendar.set(Calendar.MONTH, 0);//enero
		calendar.set(Calendar.DAY_OF_MONTH,5);
		
		filtro.setFechaHasta(calendar.getTime());
		List<AnuncioMultipleLocalizado> lista = anuncioService.findAnuncios(filtro);
		lista.size();
	}
	
	@Test
	public void deleteDummy(){
		
	}
	
	public IAnuncioService getAnuncioService() {
		return anuncioService;
	}

	public void setAnuncioService(IAnuncioService anuncioService) {
		this.anuncioService = anuncioService;
	}

	public AnuncioMultipleMapper getAnuncioMultipleMapper() {
		return anuncioMultipleMapper;
	}

	public void setAnuncioMultipleMapper(AnuncioMultipleMapper anuncioMultipleMapper) {
		this.anuncioMultipleMapper = anuncioMultipleMapper;
	}

	public DireccionMapper getDireccionMapper() {
		return direccionMapper;
	}

	public void setDireccionMapper(DireccionMapper direccionMapper) {
		this.direccionMapper = direccionMapper;
	}

	
	
	
}
