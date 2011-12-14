package com.licitaciones.anuncio;

import java.util.Date;

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
	public void testDummy(){
		
		AnuncioMultipleDTO anuncioMultipleDTO = new AnuncioMultipleDTO();
		
		anuncioMultipleDTO.setDescripcion("desc 1");
		anuncioMultipleDTO.setDireccion1("direccion 1");
		anuncioMultipleDTO.setDireccion2("direccion 2");
		anuncioMultipleDTO.setFechaCierre(new Date());
		anuncioMultipleDTO.setFechaCreacion(new Date());
		anuncioMultipleDTO.setFechaDesde(new Date());
		anuncioMultipleDTO.setFechaHasta(new Date());
		anuncioMultipleDTO.setHoraDesde(1);
		anuncioMultipleDTO.setHoraHasta(2);
		


		AnuncioMultipleLocalizado anuncio;
		
		
		anuncio = anuncioMultipleMapper.toModel(anuncioMultipleDTO);
		
		anuncioService.save(anuncio);
	}

	
	
	
}
