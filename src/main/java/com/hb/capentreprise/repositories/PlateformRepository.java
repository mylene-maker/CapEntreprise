package com.hb.capentreprise.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hb.capentreprise.entities.Plateform;

@Repository
public interface PlateformRepository extends JpaRepository <Plateform, Long>{

}
