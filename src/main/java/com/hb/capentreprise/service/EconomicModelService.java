package com.hb.capentreprise.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.hb.capentreprise.entities.EconomicModel;
import com.hb.capentreprise.repositories.EconomicModelRepository;

@Service
@Transactional
public class EconomicModelService  implements IEconomicModelService{

	@Autowired
	private EconomicModelRepository economicModelRepository;
	
	//CREATE
	public EconomicModel getEconomicModel(Long id) throws NotFoundException {
		// TODO Auto-generated method stub
		return economicModelRepository.findById(id).get();
	
	}
	public List<EconomicModel> getEconomicModels() {
		// TODO Auto-generated method stub
		return economicModelRepository.findAll();
	}
	
	//READ
	public EconomicModel save(EconomicModel economicModel) {
		// TODO Auto-generated method stub
		 
		return economicModelRepository.save(economicModel);
	}
	
	//DELETE
	public void delete(Long id) throws NotFoundException {
		// TODO Auto-generated method stub
		try {
			economicModelRepository.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			throw new NotFoundException();
		}
	}
	
	
}