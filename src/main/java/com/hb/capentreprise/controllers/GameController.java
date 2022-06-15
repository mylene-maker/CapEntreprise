package com.hb.capentreprise.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hb.capentreprise.service.EditorService;
import com.hb.capentreprise.service.IClassificationService;
import com.hb.capentreprise.service.IEconomicModelService;
import com.hb.capentreprise.service.IEditorService;
import com.hb.capentreprise.service.IGameService;
import com.hb.capentreprise.service.IGenreService;
import com.hb.capentreprise.service.IPlateformService;
import com.hb.capentreprise.service.IReviewService;
import com.hb.capentreprise.entities.Classification;
import com.hb.capentreprise.entities.EconomicModel;
import com.hb.capentreprise.entities.Editor;
import com.hb.capentreprise.entities.Game;
import com.hb.capentreprise.entities.Gamer;
import com.hb.capentreprise.entities.Genre;
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
	
	@Autowired
	private IEditorService editorService;
	
	@Autowired
	private IGenreService genreService;
	
	@Autowired
	private IClassificationService classificationService;
	
	@Autowired
	private IEconomicModelService economicModelService;
	
	
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
		
		List<Editor> editors = editorService.getEditors();
		List<Genre> genres = genreService.getGenres();
		List<Classification> classifications = classificationService.getClassifications();
		List<Plateform> plateforms = plateformService.getPlateforms();
		List<EconomicModel> economicModels = economicModelService.getEconomicModels();
		
		model.addAttribute("game", game);
		model.addAttribute("editors", editors);
		model.addAttribute("genres", genres);
		model.addAttribute("classifications",classifications);
		model.addAttribute("plateforms",plateforms);
		model.addAttribute("economicModels",economicModels);
		
		System.out.print(game);
		
		return "newGame";
	}
	
	@PostMapping
	public ModelAndView save(@ModelAttribute Game game) {
		gameService.save(game);
		System.out.println(game);
		return new ModelAndView("redirect:/game/");
	}
	
}
