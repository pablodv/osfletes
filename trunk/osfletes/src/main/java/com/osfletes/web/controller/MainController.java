package com.osfletes.web.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.osfletes.model.Contract;
import com.osfletes.security.RolesEnum;
import com.osfletes.security.User;
import com.osfletes.service.ServiceLocator;
import com.osfletes.web.dto.ContractFilterDTO;
import com.osfletes.web.model.JSONResponse;
import com.osfletes.web.model.ResultadoPaginado;

@Controller
public class MainController {

	@RequestMapping(value="/inbox")
	@PreAuthorize("isAuthenticated()")
	public ModelAndView inbox(){
		User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		GrantedAuthority authority	= principal.getAuthorities().iterator().next();
		ModelAndView mv = new ModelAndView("index");
		if(authority.getAuthority().equals(RolesEnum.ROLE_CLIENT.getRolName())){
		   mv.setViewName("client-inbox");
		}else if(authority.getAuthority().equals(RolesEnum.ROLE_PROV.getRolName())){
			mv.setViewName("provider-inbox");
		}else if(authority.getAuthority().equalsIgnoreCase(RolesEnum.ROLE_ADMIN.getRolName())){
		   mv.setViewName("admin-inbox");
		}
		
		return mv;
	}	
	
	@RequestMapping(value="/signup")
	public String signup(){
		return "signup";
	}
	
	@RequestMapping(value="/get-contracts", method=RequestMethod.GET)
	@PreAuthorize("isAuthenticated()")
	public ModelAndView getContracts(){
		return new ModelAndView("contracts");
	}
	
	@RequestMapping(value="/get-contracts", method=RequestMethod.POST)
	@PreAuthorize("isAuthenticated()")
	public @ResponseBody JSONResponse  getContracts(@ModelAttribute("filtroDTO") ContractFilterDTO filter){
		JSONResponse response = new JSONResponse();
		try {
			User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			GrantedAuthority authority	= principal.getAuthorities().iterator().next();
			if(authority.getAuthority().equals(RolesEnum.ROLE_CLIENT.getRolName())){
				filter.setUsuarioCreacion(principal.getId());
			}else if(authority.getAuthority().equals(RolesEnum.ROLE_PROV.getRolName())){
				filter.setProveedor(principal.getId());
			}
			ResultadoPaginado<Contract> contracts = ServiceLocator.getContractService().findContracts(filter);
			response.setResponse(contracts);
			response.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			response.setMessage(JsonMesagesResolver.getMessage("error.action.fatal", null, null));
			response.setSuccess(false);
		}
		return response;
	}
}

