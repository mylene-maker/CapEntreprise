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
	
	public  List<Review> getFilteredModaratedReviews(Long id) {
		Iterable<Review> reviews = reviewRepository.getFilteredModaratedReviews(id);
		return (List<Review>) reviews;
		
	}
	
}
