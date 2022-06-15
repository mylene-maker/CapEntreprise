package com.hb.capentreprise.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.WebRequest;

import com.hb.capentreprise.dto.GamerDto;

@Controller
public class RegistrationController {
	@GetMapping("/registration")
	public String getRegistrationPage(WebRequest request, Model model) {
		
		GamerDto gamerDto = new GamerDto();
		model.addAttribute("gamer", gamerDto);
		
		return "registration";
	}
}
