package com.hb.capentreprise.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.hb.capentreprise.entities.Moderator;

@Repository
public interface ModeratorRepository  extends JpaRepository<Moderator, Long>{
	
	@Query(value = "SELECT * FROM moderator WHERE pseudo = :pseudo", nativeQuery = true)
	public Moderator findByPseudo(String pseudo);
}
