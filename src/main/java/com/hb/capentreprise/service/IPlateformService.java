package com.hb.capentreprise.service;

import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import com.hb.capentreprise.entities.Plateform;

public interface IPlateformService {
	public Plateform getPlateform(Long id)throws NotFoundException;
	
	public List<Plateform> getPlateforms();
	
	public Plateform save(Plateform plateform);
	
	public void delete(Long id) throws NotFoundException;
	
	public List<Plateform> getGamePlateforme(Long id);

}
