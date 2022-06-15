package com.hb.capentreprise.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hb.capentreprise.entities.Game;
import com.hb.capentreprise.entities.Plateform;

@Repository
public interface PlateformRepository extends JpaRepository <Plateform, Long>{
	
	@Query(value="SELECT * FROM `game_plateforms`as gp JOIN `plateform` as p ON gp.plateform_id = p.plateform_id  WHERE game_id = :id", nativeQuery = true)
	public List<Plateform> findByGameId(@Param("id") Long id);
}
