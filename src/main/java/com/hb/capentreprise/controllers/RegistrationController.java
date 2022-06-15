package com.hb.capentreprise.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hb.capentreprise.entities.Gamer;
import com.hb.capentreprise.service.GamerService;

@Controller
@RequestMapping("/registration")
public class RegistrationController {
	
	private GamerService gamerService;
	
	
	public RegistrationController( GamerService gamerService ) {
		
		super();
		this.gamerService = gamerService;
	}
	
	@ModelAttribute("gamer")
	public Gamer gamerRegistration() {
		return new Gamer();
	}
	
	@GetMapping
	public String showRegistrationForm() {
		return "registration";
	}
	
	@PostMapping
	public String registerUserAccount(@ModelAttribute("gamer") Gamer gamer) {
		
		gamerService.save(gamer);
		return "redirect:/registration?success";
	}
}
