package com.osfletes.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.licitaciones.Workflow;
import com.licitaciones.exception.BusinessException;
import com.osfletes.mapper.AnuncioMultipleMapper;
import com.osfletes.model.AnuncioMultipleLocalizado;
import com.osfletes.model.AnuncioWFStateEnum;
import com.osfletes.security.User;
import com.osfletes.service.ServiceLocator;
import com.osfletes.service.interfaces.IClienteService;
import com.osfletes.web.dto.AnuncioMultipleDTO;
import com.osfletes.web.dto.FiltroAnuncioDTO;
import com.osfletes.web.dto.SignupClientDTO;
import com.osfletes.web.model.JSONResponse;
import com.osfletes.web.model.ResultadoPaginado;

@Controller
public class ClientController {

	private IClienteService clienteService;
	
	@Autowired
	@Qualifier(value="workflow-anuncio")
	private Workflow workflow;
	
	@Autowired
	private AnuncioMultipleMapper anuncioMultipleMapper;


	public void setWorkflow(Workflow workflow) {
		this.workflow = workflow;
	}


	public void setAnuncioMultipleMapper(AnuncioMultipleMapper anuncioMultipleMapper) {
		this.anuncioMultipleMapper = anuncioMultipleMapper;
	}

	
	@Autowired
	public void setClienteService(IClienteService clienteService) {
		this.clienteService = clienteService;
	}

	@RequestMapping(value="/signup-client", method=RequestMethod.GET)
	@Secured(value="IS_AUTHENTICATED_ANONYMOUSLY")
	public ModelAndView registrarse(){
		ModelAndView mv = new ModelAndView("signup-client");
		mv.addObject("formreg",new SignupClientDTO());
		return mv;
	}
	
	@RequestMapping(value="/signup-client", method=RequestMethod.POST)
	@Secured(value="IS_AUTHENTICATED_ANONYMOUSLY")
	public ModelAndView crearCliente(@ModelAttribute("formreg") @Valid SignupClientDTO registro, BindingResult result){
		if (result.hasErrors()) return new ModelAndView("signup-client");
		clienteService.createClient(registro);
		return new ModelAndView("index");
	}
	
	@RequestMapping(value="/client-announcements", method= RequestMethod.GET)
	@Secured(value="ROLE_CLIENT")
	public ModelAndView announcments(){
		ModelAndView mv = new ModelAndView("announcement");
		return mv;
	}
	
	@RequestMapping(value="/client-created-announcements", method=RequestMethod.GET)
	@Secured(value="ROLE_CLIENT")
	public ModelAndView clientCreatedAnnouncements(){
		ModelAndView mv = new ModelAndView("client-created-announcements");
		return mv;
	}
	
	@RequestMapping(value="/client-created-announcements",  method=RequestMethod.POST)
	@Secured(value="ROLE_CLIENT")
	public @ResponseBody JSONResponse clientCreatedAnnouncements(@ModelAttribute("filtroDTO") FiltroAnuncioDTO filter){
		JSONResponse response = new JSONResponse();
		try {
			User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			filter.setUsuarioCreacion(principal.getId());
			filter.setEstado(workflow.getEstadoByName(AnuncioWFStateEnum.CREADO.getName()).getIdentityVector());
			ResultadoPaginado<AnuncioMultipleLocalizado> announcements = ServiceLocator.getAnuncioService().findAnuncios(filter);
			response.setResponse(announcements);
			response.setSuccess(true);
		} catch (Exception e) {
			response.setMessage("ERRRRRORRORRORR");
			response.setSuccess(false);
		}
		return response;
	}
	
	@RequestMapping(value="/client-published-announcements", method=RequestMethod.GET)
	@Secured(value="ROLE_CLIENT")
	public ModelAndView clientPublishedAnnouncements(){
		ModelAndView mv = new ModelAndView("client-published-announcements");
		return mv;
	}

	@RequestMapping(value="/client-published-announcements",  method=RequestMethod.POST)
	@Secured(value="ROLE_CLIENT")
	public @ResponseBody JSONResponse clientPublishedAnnouncements(@ModelAttribute("filtroDTO") FiltroAnuncioDTO filter){
		JSONResponse response = new JSONResponse();
		try {
			User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			filter.setUsuarioCreacion(principal.getId());
			filter.setEstado(workflow.getEstadoByName(AnuncioWFStateEnum.PUBLICADO.getName()).getIdentityVector());
			ResultadoPaginado<AnuncioMultipleLocalizado> announcements = ServiceLocator.getAnuncioService().findAnuncios(filter);
			response.setResponse(announcements);
			response.setSuccess(true);
		} catch (Exception e) {
			response.setMessage("ERRRRRORRORRORR");
			response.setSuccess(false);
		}
		return response;
	}
	
	@RequestMapping(value="/client-canceled-announcements", method=RequestMethod.GET)
	@Secured(value="ROLE_CLIENT")
	public ModelAndView clientCanceledAnnouncements(){
		ModelAndView mv = new ModelAndView("client-canceled-announcements");
		return mv;
	}
	
	@RequestMapping(value="/client-canceled-announcements",  method=RequestMethod.POST)
	@Secured(value="ROLE_CLIENT")
	public @ResponseBody JSONResponse clientCanceledAnnouncements(@ModelAttribute("filtroDTO") FiltroAnuncioDTO filter){
		JSONResponse response = new JSONResponse();
		try {
			User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			filter.setUsuarioCreacion(principal.getId());
			filter.setEstado(workflow.getEstadoByName(AnuncioWFStateEnum.CANCELADA.getName()).getIdentityVector());
			ResultadoPaginado<AnuncioMultipleLocalizado> announcements = ServiceLocator.getAnuncioService().findAnuncios(filter);
			response.setResponse(announcements);
			response.setSuccess(true);
		} catch (Exception e) {
			response.setMessage("ERRRRRORRORRORR");
			response.setSuccess(false);
		}
		return response;
	}
	
	@RequestMapping(value="/client-closed-announcements", method=RequestMethod.GET)
	@Secured(value="ROLE_CLIENT")
	public ModelAndView clientClosedAnnouncements(){
		ModelAndView mv = new ModelAndView("client-closed-announcements");
		return mv;
	}
	
	@RequestMapping(value="/client-closed-announcements",  method=RequestMethod.POST)
	@Secured(value="ROLE_CLIENT")
	public @ResponseBody JSONResponse clientClosedAnnouncements(@ModelAttribute("filtroDTO") FiltroAnuncioDTO filter){
		JSONResponse response = new JSONResponse();
		try {
			User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			filter.setUsuarioCreacion(principal.getId());
			filter.setEstado(workflow.getEstadoByName(AnuncioWFStateEnum.CERRAR_SIN_ADJUDICACION.getName()).getIdentityVector());
			ResultadoPaginado<AnuncioMultipleLocalizado> announcements = ServiceLocator.getAnuncioService().findAnuncios(filter);
			response.setResponse(announcements);
			response.setSuccess(true);
		} catch (Exception e) {
			response.setMessage("ERRRRRORRORRORR");
			response.setSuccess(false);
		}
		return response;
	}
	
	@RequestMapping(value="/client-deleted-announcements", method=RequestMethod.GET)
	@Secured(value="ROLE_CLIENT")
	public ModelAndView clientDeletedAnnouncements(){
		ModelAndView mv = new ModelAndView("client-deleted-announcements");
		return mv;
	}
	
	@RequestMapping(value="/client-deleted-announcements",  method=RequestMethod.POST)
	@Secured(value="ROLE_CLIENT")
	public @ResponseBody JSONResponse clientDeletedAnnouncements(@ModelAttribute("filtroDTO") FiltroAnuncioDTO filter){
		JSONResponse response = new JSONResponse();
		try {
			User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			filter.setUsuarioCreacion(principal.getId());
			filter.setEstado(workflow.getEstadoByName(AnuncioWFStateEnum.ELIMINADO.getName()).getIdentityVector());
			ResultadoPaginado<AnuncioMultipleLocalizado> announcements = ServiceLocator.getAnuncioService().findAnuncios(filter);
			response.setResponse(announcements);
			response.setSuccess(true);
		} catch (Exception e) {
			response.setMessage("ERRRRRORRORRORR");
			response.setSuccess(false);
		}
		return response;
	}
	
	@RequestMapping(value="/create-announcement", method=RequestMethod.GET)
	@Secured(value="ROLE_CLIENT")
	public ModelAndView createAnnouncement(){
		ModelAndView mv = new ModelAndView("create-announcement");
		AnuncioMultipleDTO anuncio = new AnuncioMultipleDTO();
		mv.addObject("anuncioDTO",anuncio);
		return mv;
	}
	
	@RequestMapping(value="/create-announcement", method= RequestMethod.POST)
	@Secured(value="ROLE_CLIENT")
	public ModelAndView createAnnouncement(@ModelAttribute("anuncioDTO") @Valid AnuncioMultipleDTO anuncioDTO, BindingResult result){
		if (result.hasErrors()) return  new ModelAndView("create-announcement");

		AnuncioMultipleLocalizado anuncio = anuncioMultipleMapper.toModel(anuncioDTO);
		
		ServiceLocator.getAnuncioService().save(anuncio);
		
		return new ModelAndView("create-announcement"); 
	}
	
	
	
	@RequestMapping(value="/publish-announcement", method=RequestMethod.POST)
	@Secured(value="ROLE_CLIENT")
	public @ResponseBody JSONResponse publishAnnouncement(@RequestParam("announcementId") Long announcementId){
		
		JSONResponse response = new JSONResponse();
		
		try {
			ServiceLocator.getAnuncioService().publicarAnuncio(announcementId);
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
	
	@RequestMapping(value="/delete-announcement", method=RequestMethod.POST)
	@Secured(value="ROLE_CLIENT")
	public @ResponseBody JSONResponse deleteAnnouncement(@RequestParam("announcementId") Long announcementId){
		JSONResponse response = new JSONResponse();
		
		try {
			ServiceLocator.getAnuncioService().delete(announcementId);
			response.setSuccess(true);
			response.setMessage(JsonMesagesResolver.getMessage("anouncement.deleted", null, null));
		} catch (BusinessException e) {
			response.setSuccess(false);
			response.setMessage(e.getMessage());
		} catch (Exception e) {
			response.setSuccess(false);
			response.setMessage(JsonMesagesResolver.getMessage("error.action.fatal", null, null));
		}
		
		return response;
		
	}
	
	@RequestMapping(value="/cancel-announcement",  method=RequestMethod.POST)
	@Secured(value="ROLE_CLIENT")
	public @ResponseBody JSONResponse cancelAnnouncements(@RequestParam("announcementId") Long announcementId){
		JSONResponse response = new JSONResponse();

		try {
			ServiceLocator.getAnuncioService().cancelarAnuncio(announcementId);
			response.setSuccess(true);
			response.setMessage(JsonMesagesResolver.getMessage("anouncement.canceled", null, null));
		} catch (BusinessException e) {
			response.setSuccess(false);
			response.setMessage(e.getMessage());
		} catch (Exception e) {
			response.setSuccess(false);
			response.setMessage(JsonMesagesResolver.getMessage("error.action.fatal", null, null));
		}finally{
			return response;
		}
	}
	
	@RequestMapping(value="/select-offer/{announcementId}", method=RequestMethod.GET)
	@Secured(value="ROLE_CLIENT")
	public ModelAndView selectOffer(@PathVariable Long announcementId){
		User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		AnuncioMultipleLocalizado announcements = ServiceLocator.getAnuncioService().findAnuncio(announcementId,principal.getId());
		ModelAndView mv = new ModelAndView("select-offer");
		return mv;
	}
}
