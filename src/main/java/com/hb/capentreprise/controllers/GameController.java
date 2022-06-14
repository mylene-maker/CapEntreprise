package com.hb.capentreprise.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hb.capentreprise.service.IGameService;
import com.hb.capentreprise.service.IPlateformService;
import com.hb.capentreprise.service.IReviewService;
import com.hb.capentreprise.entities.Game;
import com.hb.capentreprise.entities.Plateform;


@Controller
@RequestMapping(value = "game")
public class GameController {
	
	@Autowired
	private IGameService gameService;
	
	@Autowired
	private IReviewService reviewService;
	
	@Autowired
	private IPlateformService plateformeService;
	
	
	@GetMapping
	public String getGames(Model model) {
		List<Game> games = gameService.getGames();
		model.addAttribute("games", games);
		
		List<Plateform> plateformes = plateformeService.getPlateforms();
		
		return "games";
	}
	
	@GetMapping("{id}")
	public String getGame(@PathVariable(name = "id") Long id, Model model) {
		Game game = gameService.getGame(id);
		model.addAttribute("game",game);
		return "game";
	}
	
}
