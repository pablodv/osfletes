package com.osfletes.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping(value="/hola")
	public String hola(){
		return "redirect:index"; 
	}
}
