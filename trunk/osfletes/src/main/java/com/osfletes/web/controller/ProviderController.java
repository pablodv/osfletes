package com.osfletes.web.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.osfletes.model.Oferta;
import com.osfletes.service.IOfertaService;

@Controller
public class ProviderController {

	
	IOfertaService ofertaService;
	
	@Autowired
	public void setOfertaService(IOfertaService ofertaService) {
		this.ofertaService = ofertaService;
	}
	
	
	@RequestMapping(value="/ofertar")
	public ModelAndView ofertar(){
		ModelAndView mv = new ModelAndView("ofertas"); 
		mv.addObject("oferta",  new Oferta());
		return mv;
	}
	
	@RequestMapping(value="/crearOferta")
	public String ofertar(@RequestParam(value="valorOferta") BigDecimal precio){
		Oferta oferta = new Oferta();
		oferta.setValorOferta(precio);
		ofertaService.save(oferta);
		return "redirect:ofertas"; 
	}
	
	@RequestMapping(value="/ofertas")
	public ModelAndView ofertas(){
		ModelAndView mv = new ModelAndView("ofertas-list");
		mv.addObject("ofertas",ofertaService.list());
		return mv;
	}
	
}
