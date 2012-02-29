package com.licitaciones.oferta;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.osfletes.model.AnuncioMultipleLocalizado;
import com.osfletes.model.Oferta;
import com.osfletes.model.Proveedor;
import com.osfletes.service.interfaces.IAnuncioService;
import com.osfletes.service.interfaces.IOfertaService;
import com.osfletes.service.interfaces.IProveedorService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/AnuncioServiceTest-context.xml"})
public class OfertaServiceTest {
	@Autowired
	protected IOfertaService ofertaService;

	@Autowired
	protected IAnuncioService anuncioService;

	@Autowired
	protected IProveedorService proveedorService;

	@Test
	public void saveOferta(){
		Oferta oferta = new Oferta();
		
		AnuncioMultipleLocalizado anuncio = new AnuncioMultipleLocalizado();
		anuncioService.save(anuncio);
		
		Proveedor proveedor = new Proveedor();
		proveedorService.save(proveedor);
		
		oferta.setAnuncio(anuncio);
		oferta.setValorOferta(new BigDecimal(10));
		
		
		ofertaService.save(oferta);
		
		
	}
	public IOfertaService getOfertaService() {
		return ofertaService;
	}

	public void setOfertaService(IOfertaService ofertaService) {
		this.ofertaService = ofertaService;
	}
	public IAnuncioService getAnuncioService() {
		return anuncioService;
	}
	public void setAnuncioService(IAnuncioService anuncioService) {
		this.anuncioService = anuncioService;
	}
	public IProveedorService getProveedorService() {
		return proveedorService;
	}
	public void setProveedorService(IProveedorService proveedorService) {
		this.proveedorService = proveedorService;
	}
	

}
