package com.osfletes.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.licitaciones.Workflow;
import com.licitaciones.exception.BusinessException;
import com.osfletes.mapper.OfferMapper;
import com.osfletes.model.AnuncioMultipleLocalizado;
import com.osfletes.model.AnuncioWFStateEnum;
import com.osfletes.model.Oferta;
import com.osfletes.model.OfertaWFStateEnum;
import com.osfletes.security.User;
import com.osfletes.service.ServiceLocator;
import com.osfletes.service.interfaces.IOfertaService;
import com.osfletes.web.dto.OfertaDTO;
import com.osfletes.web.dto.OfferFilterDTO;
import com.osfletes.web.dto.ProviderAnnounceFilterDTO;
import com.osfletes.web.dto.SignupProviderDTO;
import com.osfletes.web.model.JSONResponse;
import com.osfletes.web.model.ResultadoPaginado;

@Controller
public class ProviderController {

	IOfertaService ofertaService;
	OfferMapper offerMapper;
	
	@Autowired
	@Qualifier(value="workflow-anuncio")
	private Workflow workflowAnuncio;
	
	@Autowired
	@Qualifier(value="workflow-oferta")
	private Workflow workflowOffer;
	
	
	
	public void setWorkflowOffer(Workflow workflowOffer) {
		this.workflowOffer = workflowOffer;
	}

	public void setWorkflow(Workflow workflow) {
		this.workflowAnuncio = workflow;
	}
	
	@Autowired
	public void setOfertaService(IOfertaService ofertaService) {
		this.ofertaService = ofertaService;
	}
	
	@Autowired
	public void setOfferMapper(OfferMapper offerMapper) {
		this.offerMapper = offerMapper;
	}




	@RequestMapping(value="/signup-provider", method=RequestMethod.GET)
	@Secured(value="IS_AUTHENTICATED_ANONYMOUSLY")
	public ModelAndView signUp(){
		ModelAndView mv = new ModelAndView("signup-provider");
		mv.addObject("signup-form",new SignupProviderDTO());
		return mv;
	}
	
	@RequestMapping(value="/signup-provider", method=RequestMethod.POST)
	@Secured(value="IS_AUTHENTICATED_ANONYMOUSLY")
	public ModelAndView signUp(@ModelAttribute("signup-form") @Valid SignupProviderDTO reg){
		ServiceLocator.getProviderService().createProvider(reg);
		return new ModelAndView("index");
	}
	
	@RequestMapping(value="/provider-announcements",method=RequestMethod.GET)
	@Secured(value="ROLE_PROV")
	public String  providerAnnouncements(HttpServletRequest request,
		    HttpServletResponse response) {
		return  "provider-announcements";
	}
	
	
	@RequestMapping(value="/provider-announcements",  method=RequestMethod.POST)
	@Secured(value="ROLE_PROV")
	public @ResponseBody JSONResponse providerAnnouncements(@ModelAttribute("filter") ProviderAnnounceFilterDTO filter){
		JSONResponse response = new JSONResponse();
		try {
			User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			filter.setUsuarioCreacion(principal.getId());
			filter.setProviderId(principal.getId());
			filter.setStateId(workflowAnuncio.getEstadoByName(AnuncioWFStateEnum.PUBLICADO.getName()).getIdentityVector());
			
			ResultadoPaginado<AnuncioMultipleLocalizado> announcements = ServiceLocator.getAnuncioService().findAnuncios(filter);
			response.setResponse(announcements);
			response.setSuccess(true);
		} catch (Exception e) {
			response.setMessage(JsonMesagesResolver.getMessage("error.action.fatal", null, null));
			response.setSuccess(false);
		}
		return response;
	}
	
	@RequestMapping(value="/offers",method=RequestMethod.GET)
	@Secured(value="ROLE_PROV")
	public String  providerOffers(HttpServletRequest request, HttpServletResponse response) {
		return  "offers";
	}
	
	
	@RequestMapping(value="/create-offer")
	public @ResponseBody JSONResponse createOffer(@ModelAttribute("offerDTO")  @Valid OfertaDTO offerDTO, BindingResult result){
		JSONResponse response = new JSONResponse();
		response.setSuccess(true);

		if (result.hasErrors()){
			response.setErrors(result.getAllErrors());
			response.setSuccess(false);
			return response;
		} 
		
		try {
			Oferta offer = offerMapper.toModel(offerDTO);
			ofertaService.save(offer);
			
		} catch (BusinessException e) {
			response.setSuccess(false);
			response.setMessage(e.getMessage());
		}
		catch (Exception e) {
			response.setSuccess(false);
			response.setMessage(JsonMesagesResolver.getMessage("error.action.fatal", null, null));
		}
		return response;
	}
	
	@RequestMapping(value="/provider-created-offers", method=RequestMethod.GET)
	@Secured(value="ROLE_PROV")
	public ModelAndView providerCreatedOffers(){
		ModelAndView mv = new ModelAndView("provider-created-offers");
		return mv;
	}
	
	@RequestMapping(value="/provider-created-offers",  method=RequestMethod.POST)
	@Secured(value="ROLE_PROV")
	public @ResponseBody JSONResponse providerCreatedOffers(@ModelAttribute("filtroDTO") OfferFilterDTO filter){
		JSONResponse response = new JSONResponse();
		try {
			User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			filter.setUsuarioCreacion(principal.getId());
			filter.setEstado(workflowOffer.getEstadoByName(OfertaWFStateEnum.CREADO.getName()).getIdentityVector());
			ResultadoPaginado<Oferta> offers = ServiceLocator.getOfertaService().findOffers(filter);
			response.setResponse(offers);
			response.setSuccess(true);
		} catch (Exception e) {
			response.setMessage(JsonMesagesResolver.getMessage("error.action.fatal", null, null));
			response.setSuccess(false);
		}
		return response;
	}
	
	@RequestMapping(value="/provider-canceled-offers", method=RequestMethod.GET)
	@Secured(value="ROLE_PROV")
	public ModelAndView providerCanceledOffers(){
		ModelAndView mv = new ModelAndView("provider-created-offers");
		return mv;
	}
	
	@RequestMapping(value="/provider-canceled-offers",  method=RequestMethod.POST)
	@Secured(value="ROLE_PROV")
	public @ResponseBody JSONResponse providerCanceledOffers(@ModelAttribute("filtroDTO") OfferFilterDTO filter){
		JSONResponse response = new JSONResponse();
		try {
			User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			filter.setUsuarioCreacion(principal.getId());
			filter.setEstado(workflowOffer.getEstadoByName(OfertaWFStateEnum.CANCELADA_POR_PROVEEDOR.getName()).getIdentityVector());
			ResultadoPaginado<Oferta> offers = ServiceLocator.getOfertaService().findOffers(filter);
			response.setResponse(offers);
			response.setSuccess(true);
		} catch (Exception e) {
			response.setMessage(JsonMesagesResolver.getMessage("error.action.fatal", null, null));
			response.setSuccess(false);
		}
		return response;
	}
	
	@RequestMapping(value="/provider-canceled-by-client-offers", method=RequestMethod.GET)
	@Secured(value="ROLE_PROV")
	public ModelAndView providerCanceledOffersByClient(){
		ModelAndView mv = new ModelAndView("provider-canceled-by-client-offers");
		return mv;
	}
	
	@RequestMapping(value="/provider-canceled-by-client-offers",  method=RequestMethod.POST)
	@Secured(value="ROLE_PROV")
	public @ResponseBody JSONResponse providerCanceledOffersByClient(@ModelAttribute("filtroDTO") OfferFilterDTO filter){
		JSONResponse response = new JSONResponse();
		try {
			User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			filter.setUsuarioCreacion(principal.getId());
			filter.setEstado(workflowOffer.getEstadoByName(OfertaWFStateEnum.CANCELADA_POR_ANUNCIO_CANCELADO.getName()).getIdentityVector());
			ResultadoPaginado<Oferta> offers = ServiceLocator.getOfertaService().findOffers(filter);
			response.setResponse(offers);
			response.setSuccess(true);
		} catch (Exception e) {
			response.setMessage(JsonMesagesResolver.getMessage("error.action.fatal", null, null));
			response.setSuccess(false);
		}
		return response;
	}
	
	@RequestMapping(value="/provider-awarded-offers", method=RequestMethod.GET)
	@Secured(value="ROLE_PROV")
	public ModelAndView providerAwardedOffers(){
		ModelAndView mv = new ModelAndView("provider-awarded-offers");
		return mv;
	}
	
	@RequestMapping(value="/provider-awarded-offers",  method=RequestMethod.POST)
	@Secured(value="ROLE_PROV")
	public @ResponseBody JSONResponse providerAwardedOffers(@ModelAttribute("filtroDTO") OfferFilterDTO filter){
		JSONResponse response = new JSONResponse();
		try {
			User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			filter.setUsuarioCreacion(principal.getId());
			filter.setEstado(workflowOffer.getEstadoByName(OfertaWFStateEnum.ADJUDICADA.getName()).getIdentityVector());
			ResultadoPaginado<Oferta> offers = ServiceLocator.getOfertaService().findOffers(filter);
			response.setResponse(offers);
			response.setSuccess(true);
		} catch (Exception e) {
			response.setMessage(JsonMesagesResolver.getMessage("error.action.fatal", null, null));
			response.setSuccess(false);
		}
		return response;
	}
	
	@RequestMapping(value="/provider-non-awarded-offers", method=RequestMethod.GET)
	@Secured(value="ROLE_PROV")
	public ModelAndView providerNonAwardedOffers(){
		ModelAndView mv = new ModelAndView("provider-non-awarded-offers");
		return mv;
	}
	
	@RequestMapping(value="/provider-non-awarded-offers",  method=RequestMethod.POST)
	@Secured(value="ROLE_PROV")
	public @ResponseBody JSONResponse providerNonAwardedOffers(@ModelAttribute("filtroDTO") OfferFilterDTO filter){
		JSONResponse response = new JSONResponse();
		try {
			User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			filter.setUsuarioCreacion(principal.getId());
			filter.setEstado(workflowOffer.getEstadoByName(OfertaWFStateEnum.NO_ADJUDICADA.getName()).getIdentityVector());
			ResultadoPaginado<Oferta> offers = ServiceLocator.getOfertaService().findOffers(filter);
			response.setResponse(offers);
			response.setSuccess(true);
		} catch (Exception e) {
			response.setMessage(JsonMesagesResolver.getMessage("error.action.fatal", null, null));
			response.setSuccess(false);
		}
		return response;
	}
	
	@RequestMapping(value="/cancel-offer",  method=RequestMethod.POST)
	@Secured(value="ROLE_PROV")
	public @ResponseBody JSONResponse cancelOffer(@RequestParam("announcementId") Long offerId){
		JSONResponse response = new JSONResponse();
		
		User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		if(!ServiceLocator.getOfertaService().existOffer(offerId, principal.getId())){
			response.setSuccess(false);
			response.setMessage(JsonMesagesResolver.getMessage("error.action.invalid", null, null));
			return response;
		}
		
		try {
			ServiceLocator.getOfertaService().cancelOffer(offerId);
			response.setSuccess(true);
			response.setMessage(JsonMesagesResolver.getMessage("anouncement.published", null, null));
		} catch (BusinessException e) {
			response.setSuccess(false);
			response.setMessage(e.getMessage());
		} catch (Exception e) {
			response.setSuccess(false);
			response.setMessage(JsonMesagesResolver.getMessage("error.action.fatal", null, null));
		}
		return response;
	}
}
