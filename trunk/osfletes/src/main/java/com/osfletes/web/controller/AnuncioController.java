package com.osfletes.web.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.osfletes.model.AnuncioMultipleLocalizado;
import com.osfletes.service.IAnuncioService;

@Controller
public class AnuncioController {
	
	@Autowired
	IAnuncioService anuncioService;
	
	public void setAnuncioService(IAnuncioService anuncioService) {
		this.anuncioService = anuncioService;
	}

    protected Object formBackingObject(HttpServletRequest request) throws Exception {
    	AnuncioMultipleLocalizado anuncio = new AnuncioMultipleLocalizado();
    	anuncio.fechaCierre = new Date();
    	return anuncio;
    }

	@RequestMapping(value="/crearAnuncio")
	public ModelAndView crearAnuncio(){
    	AnuncioMultipleLocalizado anuncio = new AnuncioMultipleLocalizado();
		ModelAndView mv = new ModelAndView("anuncioMultiple");
		mv.addObject("anuncio",anuncio);
		return mv;
	}

    
	@RequestMapping(value="/guardarAnuncio")
	public String guardarAnuncio(@ModelAttribute("anuncio") AnuncioMultipleLocalizado anuncio){
		//AnuncioMultipleLocalizado anuncio = new AnuncioMultipleLocalizado();
		anuncio.fechaDesde = anuncio.fechaDesde;
		anuncioService.save(anuncio);
		return "redirect:listarAnuncios"; 
	}
	
	@RequestMapping(value="/listarAnuncios")
	public ModelAndView listarAnuncios(){
		ModelAndView mv = new ModelAndView("listaAnuncios");
		List lista = anuncioService.list();
		mv.addObject("lista",lista);
		return mv;
	}
    
    
	@RequestMapping(value="/anuncio")
	public String saveAnuncio(HttpServletRequest request, HttpServletResponse response){
		
		return "redirect:index"; 
	}
	
	
}
