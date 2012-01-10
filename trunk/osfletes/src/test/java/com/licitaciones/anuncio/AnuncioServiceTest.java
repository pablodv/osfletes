package com.licitaciones.anuncio;

import java.util.Calendar;
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
import com.osfletes.web.model.ResultadoPaginado;



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
		
		AnuncioMultipleDTO a1 = new AnuncioMultipleDTO("01/01/2000","01/01/2001",1,2,"ff","dd","desc");
		AnuncioMultipleDTO a2 = new AnuncioMultipleDTO("01/01/2001","01/01/2002",1,2,"ff","dd","desc");
		AnuncioMultipleDTO a3 = new AnuncioMultipleDTO("01/01/2002","01/01/2003",1,2,"ff","dd","desc");
		AnuncioMultipleDTO a4 = new AnuncioMultipleDTO("01/01/2003","01/01/2004",1,2,"ff","dd","desc");
		AnuncioMultipleDTO a5 = new AnuncioMultipleDTO("01/01/2004","01/01/2005",1,2,"ff","dd","desc");
		
		AnuncioMultipleLocalizado anuncio1;
		AnuncioMultipleLocalizado anuncio2;
		AnuncioMultipleLocalizado anuncio3;
		AnuncioMultipleLocalizado anuncio4;
		AnuncioMultipleLocalizado anuncio5;
		
		anuncio1 = anuncioMultipleMapper.toModel(a1);
		anuncio2 = anuncioMultipleMapper.toModel(a2);
		anuncio3 = anuncioMultipleMapper.toModel(a3);
		anuncio4 = anuncioMultipleMapper.toModel(a4);
		anuncio5 = anuncioMultipleMapper.toModel(a5);
		
		anuncioService.save(anuncio1);
		anuncioService.save(anuncio2);
		anuncioService.save(anuncio3);
		anuncioService.save(anuncio4);
		anuncioService.save(anuncio5);
		
	}

	@Test
	public void testFindFechas(){
		FiltroDTO filtro = new FiltroDTO();
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, 2004);
		calendar.set(Calendar.MONTH, 0);//enero
		calendar.set(Calendar.DAY_OF_MONTH,1);
		
		filtro.setFechaDesde(calendar.getTime());
		
		/*
		calendar.set(Calendar.YEAR, 2011);
		calendar.set(Calendar.MONTH, 0);//enero
		calendar.set(Calendar.DAY_OF_MONTH,1);
		
		filtro.setFechaHasta(calendar.getTime());
		*/
		filtro.setPagina(1);

		ResultadoPaginado<AnuncioMultipleLocalizado> anuncios = anuncioService.findAnuncios(filtro);
		
		List<AnuncioMultipleLocalizado> lista = anuncios.getResultados();
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
