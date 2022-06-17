package com.hb.capentreprise.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
		String sortMethod = "default";
		return new ModelAndView("redirect:/review/sort/"+sortMethod+"");
	}
	
	
	@GetMapping("/sort/{sortMethod}")
	public ModelAndView getReviewsSorted(@PathVariable(name = "sortMethod") String sort,Model model, @RequestParam("page")  Optional<Integer> page, 
			@RequestParam("size")  Optional<Integer> size) {
		Gamer gamer = gamerService.getCurrentGamer();
		Long gamerId = gamer.getId();
		List<Review> reviews = new ArrayList<Review>();
			switch(sort){

			case "sendDateAsc": 
				reviews.addAll(reviewService.getModaratedAndGamerReviewsOrderBySendDateAsc(gamerId));
				break;

			case "sendDateDsc":
				reviews.addAll(reviewService.getModaratedAndGamerReviewsOrderBySendDateDsc(gamerId));
				break;
        
			case "gameAsc":
				reviews.addAll(reviewService.getModaratedAndGamerReviewsOrderByGameAsc(gamerId));
				break;
        
			case "gameDsc":
				reviews.addAll(reviewService.getModaratedAndGamerReviewsOrderByGameDsc(gamerId));
				break;
        
			case "pseudoAsc":
				reviews.addAll(reviewService.getModaratedAndGamerReviewsOrderByPseudoAsc(gamerId));
				break;

			case "pseudoDsc":
				reviews.addAll(reviewService.getModaratedAndGamerReviewsOrderByPseudoDsc(gamerId));
				break;
        
			case "noteAsc":
				reviews.addAll(reviewService.getModaratedAndGamerReviewsOrderByNoteAsc(gamerId));
				break;
        
			case "noteDsc":
				reviews.addAll(reviewService.getModaratedAndGamerReviewsOrderByNoteDsc(gamerId));
				break;

			default:
				reviews.addAll(reviewService.getModaratedAndGamerReviews(gamerId));
				break;
			}
		System.out.println("page :"+page);
		 int currentPage = page.orElse(1);
		 System.out.println("page courrante:"+currentPage);
	        int pageSize = size.orElse(5);
	        Page<Review> reviewPage = reviewService.findPaginated(PageRequest.of(currentPage - 1, pageSize),reviews);

	        model.addAttribute("reviewPage", reviewPage);
	        
	        int totalPages = reviewPage.getTotalPages();
	        if (totalPages > 0) {
	            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
	                .boxed()
	                .collect(Collectors.toList());
	            model.addAttribute("pageNumbers", pageNumbers);
	        }
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
	public ModelAndView save(@Valid Review review, BindingResult result, Model model) {
		if (result.hasErrors()) {
			List<Game> games = gameService.getGames();
			model.addAttribute("games", games);
			return new ModelAndView("newReview");
		}
		Gamer gamer = gamerService.getCurrentGamer();
		review.setGamer(gamer);
		reviewService.save(review);
		return new ModelAndView("redirect:/review/");
	}
	
	@GetMapping("/moderator")
	public String getAllReviews(Model model) {
		List<Review> reviews = reviewService.getReviews();
		String filterMethod = null;
		model.addAttribute("filterMethod", filterMethod);
		model.addAttribute("reviews", reviews);
		return "moderatorReviews";
	}
	
	@GetMapping("/moderator/filter/{filterMethod}")
	public String getFilteredReviews(@PathVariable(name = "filterMethod") String filterMethod, Model model) {
		List<Review> reviews = new ArrayList<Review>();
		switch(filterMethod) {
		case "modarated":
			reviews.addAll(reviewService.getModeratedReviews());
			break;
			
		case "notModarated":
			reviews.addAll(reviewService.getUnmoderatedReviews());
			break;
		}
		model.addAttribute("reviews", reviews);
		model.addAttribute("filterMethod", filterMethod);
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
