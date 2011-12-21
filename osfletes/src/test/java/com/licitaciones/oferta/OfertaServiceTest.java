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
import com.osfletes.service.interfaces.IOfertaService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/AnuncioServiceTest-context.xml"})
public class OfertaServiceTest {
	@Autowired
	protected IOfertaService ofertaService;

	@Test
	public void saveOferta(){
		Oferta oferta = new Oferta();
		
		AnuncioMultipleLocalizado anuncio = new AnuncioMultipleLocalizado();
		Proveedor proveedor = new Proveedor();
		
		oferta.setProveedor(proveedor);
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
	

}