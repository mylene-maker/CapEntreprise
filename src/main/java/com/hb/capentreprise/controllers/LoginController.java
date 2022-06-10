package com.hb.capentreprise.controllers;


import javax.annotation.security.RolesAllowed;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	
	@GetMapping("/login")
	public String getLoginForm() {
		return "login";
	}
	@GetMapping("/home")
	public String getHome() {
		return "home";
	}
}
