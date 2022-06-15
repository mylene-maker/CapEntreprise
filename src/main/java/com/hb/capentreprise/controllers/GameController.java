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
import com.hb.capentreprise.entities.Review;


@Controller
@RequestMapping(value = "game")
public class GameController {
	
	@Autowired
	private IGameService gameService;
	
	@Autowired
	private IReviewService reviewService;
	
	@Autowired
	private IPlateformService plateformService;
	
	
	@GetMapping
	public String getGames(Model model) {
		List<Game> games = gameService.getGames();
		model.addAttribute("games", games);		
		return "games";
	}
	
	@GetMapping("{id}")
	public String getGameDetail(@PathVariable(name = "id") Long id, Model model) {
		Game game = gameService.getGame(id);
		model.addAttribute("game",game);
		
		List<Plateform> plateforms = plateformService.getGamePlateforme(id);
		model.addAttribute("plateforms",plateforms);
		
		List<Review> reviews = reviewService.getReviewsByGame(id);
		model.addAttribute("reviews",reviews);
		
		return "game";
	}
	
	@GetMapping("/new")
	public String getCreateForm(Model model) {
		Game game = new Game();
		model.addAttribute("game", game);
		System.out.println(game);
		return "newGame";
	}
	
}
