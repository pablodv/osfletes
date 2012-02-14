package com.osfletes.web.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.osfletes.security.RolesEnum;
import com.osfletes.security.User;

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
}

