package com.hb.capentreprise.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import com.hb.capentreprise.entities.Gamer;

@Repository
public interface GamerRepository extends JpaRepository<Gamer, Integer> {

	@Query(value = "SELECT * FROM gamer WHERE pseudo = :pseudo", nativeQuery = true)
	public Gamer findByPseudo(String pseudo);

	
	@Query(value = "SELECT * FROM gamer WHERE pseudo = :pseudo", nativeQuery = true)
	public Gamer getGamerByPseudo(String pseudo);

	
}

