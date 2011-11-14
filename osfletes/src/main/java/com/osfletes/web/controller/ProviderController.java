package com.osfletes.web.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.osfletes.model.Oferta;
import com.osfletes.service.IOfertaService;
import com.osfletes.web.dto.OfertaDTO;

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
	
	@RequestMapping(value="/getOfertas")
	public @ResponseBody List<OfertaDTO> getOfertas(){
		List<Oferta> ofertas = ofertaService.list();
		List<OfertaDTO> ofertasDto = new ArrayList<OfertaDTO>(ofertas.size());
		for(Oferta oferta : ofertas){
			OfertaDTO dto = new OfertaDTO();
			dto.setValorOferta(oferta.getValorOferta());
			dto.setId(oferta.getId());
			ofertasDto.add(dto);
		}
		return ofertasDto;
	  }
}
