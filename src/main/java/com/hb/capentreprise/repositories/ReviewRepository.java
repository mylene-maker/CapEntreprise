package com.hb.capentreprise.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hb.capentreprise.entities.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

	
}
