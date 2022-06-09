package com.hb.capentreprise.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hb.capentreprise.entities.EconomicModel;

@Repository
public interface EconomicModelRepository extends JpaRepository<EconomicModel, Long>{

}
