package com.licitaciones.anuncio;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.osfletes.model.Anuncio;
import com.osfletes.model.AnuncioMultipleLocalizado;
import com.osfletes.model.Direccion;
import com.osfletes.model.User2;
import com.osfletes.service.IAnuncioService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/AnuncioServiceTest-context.xml"})
public class AnuncioServiceTest {
	
	
	@Autowired
	protected IAnuncioService anuncioService = null;
	
	
	@Test
	public void testSaveAnuncio(){
		
		AnuncioMultipleLocalizado anuncio = new AnuncioMultipleLocalizado();
		anuncio.fechaCierre = new Date();
		anuncio.fechaCreacion = new Date();
		anuncio.fechaDesde = new Date();
		anuncio.fechaHasta = new Date();
		anuncio.horaDesde = 1;
		anuncio.horaDesde = 3;
		try {
			
			anuncioService.save(anuncio);
		} catch (Exception e) {
			junit.framework.Assert.assertTrue(false);
		}
		
		User2 u2 = new User2();
		u2.nombre = "matias";
		u2.apellido = "kochman";
		u2.email = "mati";
		u2.username = "mat";
		u2.password = "paass";
		u2.insert();
		
		anuncio.user = u2;
		
		
		anuncioService.save(anuncio);
	}
	

	@Test
	public void testSaveAnuncioMultipleLocalizado(){
		AnuncioMultipleLocalizado anuncio = new AnuncioMultipleLocalizado();
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
		
		
		Direccion d1= new Direccion();
		d1.direccion = "sarasa";
		d1.latitud = new BigDecimal(3);
		d1.longitud = new BigDecimal(3);
		
		
		
		//anuncio.listaDirecciones.asList().add(d1);
		
		anuncio.user = u2;
		
		anuncio.save();
		
		d1.anuncio = anuncio;
		d1.save();
		//anuncioService.save(anuncio);
	}	
	@Test
	public void testRollbackSaveAnuncio(){
		int size = anuncioService.list().size();
		AnuncioMultipleLocalizado anuncio = new AnuncioMultipleLocalizado();
		anuncio.fechaCierre = new Date();
		anuncio.fechaCreacion = new Date();
		anuncio.fechaDesde = new Date();
		anuncio.fechaHasta = new Date();
		anuncio.horaDesde = 1;
		anuncio.horaDesde = 3;
		
		try {
			anuncioService.saveRollback(anuncio);
			junit.framework.Assert.assertTrue(false);
		} catch (Exception e) {
			junit.framework.Assert.assertTrue(true);
		}
			
		
			junit.framework.Assert.assertTrue(anuncioService.list().size() == size);
		
		
	}
	
}
