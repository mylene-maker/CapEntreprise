package com.hb.capentreprise.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hb.capentreprise.service.IGameService;
import com.hb.capentreprise.entities.Game;


@Controller
@RequestMapping(value = "game")
public class GameController {
	
	@Autowired
	private IGameService gameService;
	
	
	@GetMapping
	public String getGames(Model model) {
		List<Game> games = gameService.getGames();
		model.addAttribute("games", games);
		return "games";
	}
}
