package com.hb.capentreprise.service;

import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import com.hb.capentreprise.entities.EconomicModel;

public interface IEconomicModelService {
	
	public EconomicModel getEconomicModel(Long id)throws NotFoundException;
	
	public List<EconomicModel> getEconomicModels();
	
	public EconomicModel save(EconomicModel economicModel);
	
	public void delete(Long id) throws NotFoundException;
	
	
	
	
}
