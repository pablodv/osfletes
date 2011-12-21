package com.licitaciones.proveedor;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.osfletes.model.Proveedor;
import com.osfletes.service.interfaces.IProveedorService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/AnuncioServiceTest-context.xml"})
public class ProveedorServiceTest {
	
	@Autowired
	protected IProveedorService proveedorService;

	@Test
	public void saveProveedor(){
		
		Proveedor proveedor = new Proveedor();
		
		proveedor.setUsername("carlitox");
		proveedor.setPassword("carlitox");
		
		
		proveedorService.saveOrUpdate(proveedor);
		
	}
	
	
	public IProveedorService getProveedorService() {
		return proveedorService;
	}

	public void setProveedorService(IProveedorService proveedorService) {
		this.proveedorService = proveedorService;
	}

	
}
