package com.licitaciones.anuncio;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.osfletes.model.Anuncio;
import com.osfletes.model.User2;
import com.osfletes.service.AnuncioService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/AnuncioServiceTest-context.xml")
public class AnuncioServiceTest {
	
	@Autowired
	protected AnuncioService anuncioService = null;
	
	@Test
	public void testSaveAnuncio(){
		Anuncio anuncio = new Anuncio();
		anuncio.fechaCierre = new Date();
		anuncio.fechaCreacion = new Date();
		anuncio.fechaDesde = new Date();
		anuncio.fechaHasta = new Date();
		anuncio.horaDesde = 1;
		anuncio.horaDesde = 3;
		
		User2 u2 = new User2();
		u2.nombre = "matias";
		u2.apellido = "kochman";
		u2.email = "mati";
		u2.username = "mat";
		u2.password = "paass";
		u2.insert();
		
		anuncio.user = u2;
		
		anuncio.insert();
		//anuncioService.save(anuncio);
	}
	
	@Test
	public void testRollbackSaveAnuncio(){
		int size = anuncioService.list().size();
		Anuncio anuncio = new Anuncio();
		anuncio.fechaCierre = new Date();
		anuncio.fechaCreacion = new Date();
		anuncio.fechaDesde = new Date();
		anuncio.fechaHasta = new Date();
		anuncio.horaDesde = 1;
		anuncio.horaDesde = 3;
		
		anuncioService.rollbackSave(anuncio);
		
		junit.framework.Assert.assertTrue(anuncioService.list().size() == size);
	}
	
}
