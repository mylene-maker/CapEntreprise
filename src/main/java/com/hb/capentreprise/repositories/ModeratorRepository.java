package com.hb.capentreprise.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hb.capentreprise.entities.Moderator;

@Repository
public interface ModeratorRepository  extends JpaRepository<Moderator, Long>{

}
