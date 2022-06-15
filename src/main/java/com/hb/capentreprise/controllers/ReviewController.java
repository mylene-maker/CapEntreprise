package com.hb.capentreprise.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
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

import com.hb.capentreprise.entities.Game;
import com.hb.capentreprise.entities.Gamer;
import com.hb.capentreprise.entities.Moderator;
import com.hb.capentreprise.entities.Review;
import com.hb.capentreprise.service.IGameService;
import com.hb.capentreprise.service.IGamerService;
import com.hb.capentreprise.service.IModeratorService;
import com.hb.capentreprise.service.IReviewService;




@Controller
@RequestMapping(value = "review")
public class ReviewController {
	
	@Autowired
	private IReviewService reviewService;
	
	@Autowired
	private IGameService gameService;

	@Autowired
	private IGamerService gamerService;
	
	@Autowired
	private IModeratorService moderatorService;
	
	@GetMapping
	public ModelAndView getReviews(Model model) {
		Gamer gamer = gamerService.getCurrentGamer();
		if (gamer == null) {
			return new ModelAndView("redirect:/review/moderator");
		}
		Long gamerId = gamer.getId();
		List<Review> reviewsToRender = new ArrayList<Review>();
		List<Review> gamerReviews = reviewService.getReviewsByGamer(gamerId);
		List<Review> filteredModaratedReviews = reviewService.getFilteredModaratedReviews(gamerId);
		reviewsToRender.addAll(gamerReviews);
		reviewsToRender.addAll(filteredModaratedReviews);
		
		
		model.addAttribute("reviews", reviewsToRender);
		return new ModelAndView("reviews");
	}
	

	
	@GetMapping("{id}")
	public String getReview(@PathVariable(name = "id") Long id,Model model) {
		Review review =reviewService.getReview(id);		
		model.addAttribute("review", review);
		return "review";
	}
	
	@GetMapping("/new")
	public String getCreateForm(Model model) {
		Review review = new Review();
		List<Game> games = gameService.getGames();
		model.addAttribute("games", games);
		model.addAttribute("review", review);
		return "newReview";
	}
	
	@PostMapping
	public ModelAndView save(@ModelAttribute Review review) {
		Gamer gamer = gamerService.getCurrentGamer();
		review.setGamer(gamer);
		reviewService.save(review);
		return new ModelAndView("redirect:/review/");
	}
	
	@GetMapping("/moderator")
	public String getAllReviews(Model model) {
		List<Review> reviews = reviewService.getReviews();
		model.addAttribute("reviews", reviews);
		return "moderatorReviews";
	}
	
	@GetMapping("/moderator/{id}")
	public String getModeratorReview(@PathVariable(name = "id") Long id,Model model) {
		Review review =reviewService.getReview(id);		
		model.addAttribute("review", review);
		return "moderatorReview";
	}
	
	@GetMapping("/moderator/{id}/delete")
	public ModelAndView delete(@PathVariable(name = "id") Long id) {
		reviewService.delete(id);
		return new ModelAndView("redirect:/review/moderator");
	}
	
	@GetMapping("/moderator/{id}/validate")
	public ModelAndView validate(@PathVariable(name = "id") Long id) {
		Review review = reviewService.getReview(id);
		review.setModerationDate(LocalDate.now());
		Moderator moderator = moderatorService.getCurrentModerator();
		review.setModerator(moderator);
		reviewService.save(review);
		
		return new ModelAndView("redirect:/review/moderator");
	}


}
