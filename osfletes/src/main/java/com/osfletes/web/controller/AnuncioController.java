package com.osfletes.web.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.osfletes.mapper.AnuncioMultipleMapper;
import com.osfletes.mapper.DireccionMapper;
import com.osfletes.model.AnuncioMultipleLocalizado;
import com.osfletes.model.Direccion;
import com.osfletes.service.IAnuncioService;
import com.osfletes.web.dto.AnuncioMultipleDTO;
import siena.PersistenceManagerFactory;

@Controller
public class AnuncioController {
	
	@Autowired
	private IAnuncioService anuncioService;
	
	@Autowired
	private AnuncioMultipleMapper anuncioMultipleMapper;

	@Autowired
	private DireccionMapper direccionMapper;
	

	public void setAnuncioMultipleMapper(AnuncioMultipleMapper anuncioMultipleMapper) {
		this.anuncioMultipleMapper = anuncioMultipleMapper;
	}

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
		AnuncioMultipleDTO anuncio = new AnuncioMultipleDTO();
		ModelAndView mv = new ModelAndView("anuncioMultiple");
		mv.addObject("anuncioDTO",anuncio);
		return mv;
	}

    
	@RequestMapping(value="/guardarAnuncio")
	public String guardarAnuncio(@ModelAttribute("anuncioDTO") AnuncioMultipleDTO anuncioDTO){
		
		AnuncioMultipleLocalizado anuncio = anuncioMultipleMapper.toModel(anuncioDTO);
		
		Direccion direccion1 = direccionMapper.fromAnuncioDTOToModel(anuncioDTO.getDireccion1(), 1);

		Direccion direccion2 = direccionMapper.fromAnuncioDTOToModel(anuncioDTO.getDireccion2(), 2);

		List<Direccion> listaDirecciones = new ArrayList<Direccion>();
		listaDirecciones.add(direccion1);
		listaDirecciones.add(direccion2);
		
		//anuncioService.save(anuncio);

		anuncioService.saveWithAddresses(anuncio, listaDirecciones);
		for (Direccion direccion : listaDirecciones) {
			direccion.owner = anuncio;
			PersistenceManagerFactory.getPersistenceManager(Direccion.class).save(direccion);
		}
		
		return "redirect:listarAnuncios"; 
	}
	
	@RequestMapping(value="/listarAnuncios")
	public ModelAndView listarAnuncios(){
		ModelAndView mv = new ModelAndView("listaAnuncios");
		List<AnuncioMultipleLocalizado> lista = anuncioService.list();
		
		List<AnuncioMultipleDTO> dtoList = anuncioMultipleMapper.toDTO(lista);
		
		mv.addObject("lista",dtoList);
		return mv;
	}
    
    
	@RequestMapping(value="/anuncio")
	public String saveAnuncio(HttpServletRequest request, HttpServletResponse response){
		
		return "redirect:index"; 
	}

	public void setDireccionMapper(DireccionMapper direccionMapper) {
		this.direccionMapper = direccionMapper;
	}
	
	
}
