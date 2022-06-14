package com.hb.capentreprise.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hb.capentreprise.entities.Plateform;

@Repository
public interface PlateformRepository extends JpaRepository <Plateform, Long>{
	
//	@Query(Value="SELECT * FROM `game_plateforms` WHERE game_id = :id, nativeQuery = true)"
//	public List<Game> findByNameSQL(@Param("id") String id);
}
