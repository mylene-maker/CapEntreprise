package com.hb.capentreprise.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hb.capentreprise.entities.Classification;


@Repository
public interface ClassificationRepository  extends JpaRepository<Classification, Long> {

}
