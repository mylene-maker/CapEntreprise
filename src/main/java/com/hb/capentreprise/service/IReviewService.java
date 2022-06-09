package com.hb.capentreprise.service;

import java.util.List;

import com.hb.capentreprise.entities.Review;

public interface IReviewService {
	
	public Review getReview(Long id);

	public List<Review> getReviews();

	public Review save(Review review);

	public void delete(Long id);
}
