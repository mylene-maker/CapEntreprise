package com.hb.capentreprise.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hb.capentreprise.entities.Gamer;
import com.hb.capentreprise.entities.InternalUser;

@Repository
public interface GamerRepository extends JpaRepository<Gamer, Integer> {
}
