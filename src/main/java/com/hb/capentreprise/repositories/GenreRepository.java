package com.hb.capentreprise.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hb.capentreprise.entities.Genre;

@Repository
public interface  GenreRepository extends JpaRepository<Genre, Long>  {

}
