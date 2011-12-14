package com.osfletes.web.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.osfletes.mapper.AnuncioMultipleMapper;
import com.osfletes.model.AnuncioMultipleLocalizado;
import com.osfletes.service.interfaces.IAnuncioService;
import com.osfletes.web.dto.AnuncioMultipleDTO;
import com.osfletes.web.dto.FiltroDTO;

@Controller
public class AnuncioController {
	
	@Autowired
	private IAnuncioService anuncioService;
	
	@Autowired
	private AnuncioMultipleMapper anuncioMultipleMapper;


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

	@RequestMapping(value="/crearAnuncio", method= RequestMethod.GET)
	public ModelAndView crearAnuncio(){
		AnuncioMultipleDTO anuncio = new AnuncioMultipleDTO();
		ModelAndView mv = new ModelAndView("anuncioMultiple");
		mv.addObject("anuncioDTO",anuncio);
		return mv;
	}

    
	@RequestMapping(value="/guardarAnuncio", method= RequestMethod.POST)
	public String guardarAnuncio(@ModelAttribute("anuncioDTO") @Valid AnuncioMultipleDTO anuncioDTO, BindingResult result){

		if (result.hasErrors()) return "anuncioMultiple";

		AnuncioMultipleLocalizado anuncio = anuncioMultipleMapper.toModel(anuncioDTO);
		
		anuncioService.save(anuncio);
		
		return "redirect:listarAnuncios"; 
	}
	
	@RequestMapping(value="/listarAnuncios")
	public ModelAndView listarAnuncios(){
		ModelAndView mv = new ModelAndView("listaAnuncios");
		List<AnuncioMultipleLocalizado> lista = anuncioService.getAll();
		
		List<AnuncioMultipleDTO> dtoList = anuncioMultipleMapper.toDTO(lista);
		
		mv.addObject("lista",dtoList);
		return mv;
	}
    
    
	@RequestMapping(value="/anuncio")
	public String borrarAnuncio(@ModelAttribute("anuncioDTO")AnuncioMultipleDTO anuncioDTO){
		
		AnuncioMultipleLocalizado anuncio = anuncioService.getById(anuncioDTO.getId());
		
		anuncioService.delete(anuncio);
		
		return "redirect:listarAnuncios";
	}

	@RequestMapping(value="/obtenerAnunciosFiltrados")
	public @ResponseBody List<AnuncioMultipleDTO> getAnunciosFiltrados(@ModelAttribute("filtroDTO") FiltroDTO filtro ){
		List<AnuncioMultipleLocalizado> anuncios = anuncioService.findAnuncios(filtro);
		return anuncioMultipleMapper.toDTO(anuncios);
	 }

	public IAnuncioService getAnuncioService() {
		return anuncioService;
	}

	public AnuncioMultipleMapper getAnuncioMultipleMapper() {
		return anuncioMultipleMapper;
	}

}
