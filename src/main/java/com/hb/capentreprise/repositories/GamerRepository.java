package com.hb.capentreprise.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hb.capentreprise.entities.Gamer;

@Repository
public interface GamerRepository extends JpaRepository<Gamer, Integer> {

}
