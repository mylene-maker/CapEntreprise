package com.hb.capentreprise.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.hb.capentreprise.entities.Review;

public interface IReviewService {
	
	
	public Review getReview(Long id);

	public List<Review> getReviews();

	public Review save(Review review);

	public void delete(Long id);
	
	public List<Review> getReviewsByGamer(Long id);
	
	public List<Review> getModaratedAndGamerReviews(Long id);
	
	public List<Review> getReviewsByGame(Long id);
	
	public  List<Review> getModaratedAndGamerReviewsOrderBySendDateAsc(Long id);
	
	public  List<Review> getModaratedAndGamerReviewsOrderBySendDateDsc(Long id);
	
	public  List<Review> getModaratedAndGamerReviewsOrderByGameAsc(Long id);
	
	public  List<Review> getModaratedAndGamerReviewsOrderByGameDsc(Long id);
	
	public  List<Review> getModaratedAndGamerReviewsOrderByPseudoAsc(Long id);
	
	public  List<Review> getModaratedAndGamerReviewsOrderByPseudoDsc(Long id);
	
	public  List<Review> getModaratedAndGamerReviewsOrderByNoteAsc(Long id);
	
	public  List<Review> getModaratedAndGamerReviewsOrderByNoteDsc(Long id);
	
	public  List<Review> getModeratedReviews();
	
	public  List<Review> getUnmoderatedReviews();
	
	public Page<Review> findPaginated(Pageable pageable, List<Review> reviews);
	
}
