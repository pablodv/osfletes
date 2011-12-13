package com.osfletes.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.osfletes.model.Oferta;
import com.osfletes.service.interfaces.IOfertaService;
import com.osfletes.web.dto.OfertaDTO;

@Controller
public class ProviderController {

	IOfertaService ofertaService;
	
	
	@Autowired
	public void setOfertaService(IOfertaService ofertaService) {
		this.ofertaService = ofertaService;
	}
	
	
	@RequestMapping(value="/ofertar" , method= RequestMethod.GET)
	public ModelAndView ofertar(){
		ModelAndView mv = new ModelAndView("ofertar"); 
		mv.addObject("oferta",  new OfertaDTO());
		return mv;
	}
	
	@RequestMapping(value="/ofertar", method= RequestMethod.POST)
	public String ofertar(@ModelAttribute("oferta") @Valid OfertaDTO oferta, BindingResult result){
		if (result.hasErrors()) return "ofertar";
		Oferta ofertaObj = new Oferta();
		ofertaObj.setValorOferta(oferta.getValorOferta());
		ofertaService.save(ofertaObj);
		return "redirect:ofertas"; 
	}
	
	@RequestMapping(value="/ofertas", method = RequestMethod.GET)
	public ModelAndView ofertas(){
		ModelAndView mv = new ModelAndView("ofertas");
		mv.addObject("ofertas",ofertaService.getAll());
		return mv;
	}
	
	@RequestMapping(value="/getOfertas")
	public @ResponseBody List<OfertaDTO> getOfertas(){
		List<Oferta> ofertas = ofertaService.getAll();
		List<OfertaDTO> ofertasDto = new ArrayList<OfertaDTO>(ofertas.size());
		for(Oferta oferta : ofertas){
			OfertaDTO dto = new OfertaDTO();
			dto.setValorOferta(oferta.getValorOferta());
			dto.setId(oferta.getId());
			ofertasDto.add(dto);
		}
		return ofertasDto;
	  }	
	
	@RequestMapping(value="/perfil")
	//@Secured('isAuthenticated()')
	public ModelAndView miPerfil(){
		/*User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		GrantedAuthority authority	= principal.getAuthorities().iterator().next();
		   
		if(authority.getAuthority().equals(RolesEnum.ROL_USER)){
		   ModelAndView mv = new ModelAndView("usuario");
		   return mv;
		}else if(authority.getAuthority().equals(RolesEnum.ROL_PROVEEDOR)){*/
		   ModelAndView mv = new ModelAndView("proveedor");
		   return mv;
		 /*  
		}else{
		   //TODO esto deberia ser un error
		   ModelAndView mv = new ModelAndView("index");
		   return mv;
		}*/
	}
	
//	@RequestMapping(value="/anuncios")
//	public ModelAndView getAnuncios(){
//		
//	}
}
