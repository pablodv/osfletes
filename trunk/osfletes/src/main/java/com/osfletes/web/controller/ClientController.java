package com.osfletes.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.osfletes.service.interfaces.IClienteService;
import com.osfletes.web.dto.RegistroDTO;

@Controller
public class ClientController {

	private IClienteService clienteService;
	
	@Autowired
	public void setClienteService(IClienteService clienteService) {
		this.clienteService = clienteService;
	}

	@RequestMapping(value="/registrarse", method=RequestMethod.GET)
	public ModelAndView registrarse(){
		ModelAndView mv = new ModelAndView("registrarse");
		mv.addObject("formreg",new RegistroDTO());
		return mv;
	}
	
	@RequestMapping(value="/registrarse", method=RequestMethod.POST)
	public ModelAndView crearCliente(@ModelAttribute("formreg") @Valid RegistroDTO registro){
		clienteService.createClient(registro);
		return new ModelAndView("perfil");
	}
	
}
