package com.hb.capentreprise.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hb.capentreprise.entities.Game;
import com.hb.capentreprise.entities.Review;
import com.hb.capentreprise.service.IGameService;
import com.hb.capentreprise.service.IReviewService;



@Controller
@RequestMapping(value = "review")
public class ReviewController {
	
	@Autowired
	private IReviewService reviewService;
	
	@Autowired
	private IGameService gameService;
	
	@GetMapping
	public String getReviews(Model model) {
		List<Review> reviewsToRender = new ArrayList<Review>();
		List<Review> gamerReviews = reviewService.getReviewsByGamer(1L);
		List<Review> filteredModaratedReviews = reviewService.getFilteredModaratedReviews(1L);
		reviewsToRender.addAll(gamerReviews);
		reviewsToRender.addAll(filteredModaratedReviews);
		
		
		model.addAttribute("reviews", reviewsToRender);
		return "reviews";
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
	

}
