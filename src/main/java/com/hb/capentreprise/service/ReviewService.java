package com.hb.capentreprise.service;

import java.util.List;



import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hb.capentreprise.entities.Review;
import com.hb.capentreprise.repositories.ReviewRepository;

@Service
@Transactional
public class ReviewService implements IReviewService{
	
	@Autowired
	private ReviewRepository reviewRepository;
	
	@Override
	public Review getReview(Long id) {
		Review review = reviewRepository.findById(id).get();
		return review;
	}

	@Override
	public List<Review> getReviews() {
		Iterable<Review> reviews = reviewRepository.findAll();
		return (List<Review>) reviews;
	}

	@Override
	public Review save(Review review) {
		review = reviewRepository.save(review);
		return review;
	}

	@Override
	public void delete(Long id) {
		reviewRepository.deleteById(id);
		
	}
	
	
	public  List<Review> getReviewsByGamer(Long id) {
		Iterable<Review> reviews = reviewRepository.getReviewsByGamer(id);
		return (List<Review>) reviews;
		
	}
	
	public  List<Review> getModaratedAndGamerReviews(Long id) {
		Iterable<Review> reviews = reviewRepository.getModaratedAndGamerReviews(id);
		return (List<Review>) reviews;
		
	}

	@Override
	public List<Review> getReviewsByGame(Long id) {
		Iterable<Review> reviews = reviewRepository.getReviewsByGame(id);
		return (List<Review>) reviews;
		}

	@Override
	public List<Review> getModaratedAndGamerReviewsOrderBySendDateAsc(Long id) {
		Iterable<Review> reviews = reviewRepository.getModaratedAndGamerReviewsOrderBySendDateAsc(id);
		return (List<Review>) reviews;
	}

	@Override
	public List<Review> getModaratedAndGamerReviewsOrderBySendDateDsc(Long id) {
		Iterable<Review> reviews = reviewRepository.getModaratedAndGamerReviewsOrderBySendDateDsc(id);
		return (List<Review>) reviews;
	}

	@Override
	public List<Review> getModaratedAndGamerReviewsOrderByGameAsc(Long id) {
		Iterable<Review> reviews = reviewRepository.getModaratedAndGamerReviewsOrderByGameAsc(id);
		return (List<Review>) reviews;
	}

	@Override
	public List<Review> getModaratedAndGamerReviewsOrderByGameDsc(Long id) {
		Iterable<Review> reviews = reviewRepository.getModaratedAndGamerReviewsOrderByGameDsc(id);
		return (List<Review>) reviews;
	}

	@Override
	public List<Review> getModaratedAndGamerReviewsOrderByPseudoAsc(Long id) {
		Iterable<Review> reviews = reviewRepository.getModaratedAndGamerReviewsOrderByPseudoAsc(id);
		return (List<Review>) reviews;
	}

	@Override
	public List<Review> getModaratedAndGamerReviewsOrderByPseudoDsc(Long id) {
		Iterable<Review> reviews = reviewRepository.getModaratedAndGamerReviewsOrderByPseudoDsc(id);
		return (List<Review>) reviews;
	}

	@Override
	public List<Review> getModaratedAndGamerReviewsOrderByNoteAsc(Long id) {
		Iterable<Review> reviews = reviewRepository.getModaratedAndGamerReviewsOrderByNoteAsc(id);
		return (List<Review>) reviews;
	}

	@Override
	public List<Review> getModaratedAndGamerReviewsOrderByNoteDsc(Long id) {
		Iterable<Review> reviews = reviewRepository.getModaratedAndGamerReviewsOrderByNoteDsc(id);
		return (List<Review>) reviews;
	}

	@Override
	public List<Review> getModeratedReviews() {
		Iterable<Review> reviews = reviewRepository.getModeratedReviews();
		return (List<Review>) reviews;
	}

	@Override
	public List<Review> getUnmoderatedReviews() {
		Iterable<Review> reviews = reviewRepository.getUnmoderatedReviews();
		return (List<Review>) reviews;
	}
	
}
