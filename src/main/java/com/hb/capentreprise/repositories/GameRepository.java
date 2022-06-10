package com.hb.capentreprise.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hb.capentreprise.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long> {

}
