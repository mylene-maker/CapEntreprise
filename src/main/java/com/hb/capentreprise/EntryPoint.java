package com.hb.capentreprise;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.hb.capentreprise.entities.Classification;
import com.hb.capentreprise.entities.Genre;
import com.hb.capentreprise.entities.Review;
import com.hb.capentreprise.service.IClassificationService;
import com.hb.capentreprise.service.IGenreService;
import com.hb.capentreprise.service.IReviewService;


@Component
public class EntryPoint implements CommandLineRunner{
	
	private static Logger logger = LoggerFactory.getLogger(EntryPoint.class);
	
	@Autowired
	private IClassificationService classificationService;

	@Autowired
	private IGenreService genreService;
	
	@Autowired
	private IReviewService reviewService;
	
	@Override
	public void run(String... args) throws Exception {
	
		
		
	}
	
	private void printClassification(){
			
		List<Classification> classifications = classificationService.getClassifications();
		
		for(Classification classification: classifications) {
			System.out.print(classification);
		}
		
	}
	
	private void printGenre(){
		
		List<Genre> genres = genreService.getGenres();
		
		for(Genre genre: genres) {
			System.out.print(genre);
		}
		
	}
	
	private void printReview(){
		
		List<Review> reviews = reviewService.getReviews();
		
		for(Review review: reviews) {
			System.out.print(review);
		}
		
	}

}
