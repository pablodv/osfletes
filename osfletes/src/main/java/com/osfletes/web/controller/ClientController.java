package com.osfletes.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.osfletes.service.interfaces.IClienteService;
import com.osfletes.web.dto.SignupClientDTO;

@Controller
public class ClientController {

	private IClienteService clienteService;
	
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
	public ModelAndView crearCliente(@ModelAttribute("formreg") @Valid SignupClientDTO registro){
		clienteService.createClient(registro);
		return new ModelAndView("index");
	}
	
}
