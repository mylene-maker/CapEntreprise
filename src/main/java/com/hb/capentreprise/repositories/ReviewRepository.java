package com.hb.capentreprise.repositories;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hb.capentreprise.entities.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

	@Query(value = "SELECT * FROM review WHERE gamer_id = :id", nativeQuery = true)
	public  List<Review> getReviewsByGamer(Long id);
	
	@Query(value = "SELECT * FROM review WHERE moderation_date IS NOT NULL AND gamer_id != :id", nativeQuery = true)
	public  List<Review> getFilteredModaratedReviews(Long id);
}
