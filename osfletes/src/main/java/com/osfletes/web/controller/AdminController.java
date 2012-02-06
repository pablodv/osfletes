
package com.osfletes.web.controller;
import javax.validation.Valid;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.osfletes.security.Role;
import com.osfletes.security.User;
import com.osfletes.service.ServiceLocator;
import com.osfletes.service.interfaces.IUserService;
import com.osfletes.web.dto.RoleDTO;
import com.osfletes.web.dto.RoleFilterDTO;
import com.osfletes.web.dto.UserFilterDTO;
import com.osfletes.web.model.JSONResponse;
import com.osfletes.web.model.ResultadoPaginado;

@Controller
@Secured(value="ROLE_ADMIN")
public class AdminController {

	@RequestMapping(value="/manage-users")
	public String manageUsers(@ModelAttribute("filtroDTO") UserFilterDTO filter){
		return "abm-user";
	}
	
	@RequestMapping(value="/manage-roles")
	public String manageRoles(@ModelAttribute("filtroDTO") UserFilterDTO filter){
		return "abm-role";
	}
	
	@RequestMapping(value="/get-users")
	public @ResponseBody ResultadoPaginado<User> getUsers(@ModelAttribute("filtroDTO") UserFilterDTO filter){
		ResultadoPaginado<User> users = ServiceLocator.getUserService().getUsers(filter);
		return users;
	}
	
	@RequestMapping(value="/chng-user-status")
	public @ResponseBody boolean changeUserStatus(@RequestParam("userId") Long userId){
		IUserService service = ServiceLocator.getUserService();
		User user = service.getById(userId);
		user.setEnable(!user.isEnabled());
		service.save(user);
		return true;
	}
	
	@RequestMapping(value="/get-roles")
	public @ResponseBody ResultadoPaginado<Role> getRoles(@ModelAttribute("filtroDTO") RoleFilterDTO filter){
		ResultadoPaginado<Role> roles = ServiceLocator.getRoleService().getRoles(filter);
		return roles;
	}
	
	@RequestMapping(value="/create-role")
	public @ResponseBody JSONResponse createRole(@ModelAttribute("roleDTO")  @Valid RoleDTO roleDTO, BindingResult result){
		JSONResponse response = new JSONResponse();
		if (result.hasErrors()){
			response.setErrors(result.getAllErrors());
			response.setSuccess(false);
			return response;
		} 
		
		Role role = new Role();
		role.setRole(roleDTO.getRole());
		ServiceLocator.getRoleService().save(role);
		response.setMessage("Genial Mostri");
		return response;
	}
}
