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
	
	@Query(value = "SELECT * FROM review WHERE moderation_date IS NOT NULL OR gamer_id= :id", nativeQuery = true)
	public  List<Review> getModaratedAndGamerReviews(Long id);
	
	@Query(value = "SELECT * FROM review WHERE moderation_date IS NOT NULL OR gamer_id= :id ORDER BY send_date ASC", nativeQuery = true)
	public  List<Review> getModaratedAndGamerReviewsOrderBySendDateAsc(Long id);
	
	@Query(value = "SELECT * FROM review WHERE moderation_date IS NOT NULL OR gamer_id= :id ORDER BY send_date DESC", nativeQuery = true)
	public  List<Review> getModaratedAndGamerReviewsOrderBySendDateDsc(Long id);
	
	@Query(value = "SELECT * FROM review AS r INNER JOIN game AS g ON r.game_id= g.game_id WHERE r.moderation_date IS NOT NULL OR r.gamer_id= :id ORDER BY g.name ASC", nativeQuery = true)
	public  List<Review> getModaratedAndGamerReviewsOrderByGameAsc(Long id);
	
	@Query(value = "SELECT * FROM review AS r INNER JOIN game AS g ON r.game_id= g.game_id WHERE r.moderation_date IS NOT NULL OR r.gamer_id= :id ORDER BY g.name DESC", nativeQuery = true)
	public  List<Review> getModaratedAndGamerReviewsOrderByGameDsc(Long id);
	
	@Query(value = "SELECT * FROM review AS r INNER JOIN gamer AS g ON r.gamer_id= g.user_id WHERE r.moderation_date IS NOT NULL OR r.gamer_id= :id ORDER BY g.pseudo ASC", nativeQuery = true)
	public  List<Review> getModaratedAndGamerReviewsOrderByPseudoAsc(Long id);
	
	@Query(value = "SELECT * FROM review AS r INNER JOIN gamer AS g ON r.gamer_id= g.user_id WHERE r.moderation_date IS NOT NULL OR r.gamer_id= :id ORDER BY g.pseudo DESC", nativeQuery = true)
	public  List<Review> getModaratedAndGamerReviewsOrderByPseudoDsc(Long id);
	
	@Query(value = "SELECT * FROM review WHERE moderation_date IS NOT NULL OR gamer_id= :id ORDER BY note ASC", nativeQuery = true)
	public  List<Review> getModaratedAndGamerReviewsOrderByNoteAsc(Long id);
	
	@Query(value = "SELECT * FROM review WHERE moderation_date IS NOT NULL OR gamer_id= :id ORDER BY note DESC", nativeQuery = true)
	public  List<Review> getModaratedAndGamerReviewsOrderByNoteDsc(Long id);
	
	@Query(value = "SELECT * FROM review WHERE game_id = :id", nativeQuery = true)
	public  List<Review> getReviewsByGame(Long id);
}
