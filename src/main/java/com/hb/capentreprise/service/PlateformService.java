package com.hb.capentreprise.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.hb.capentreprise.entities.Plateform;
import com.hb.capentreprise.repositories.PlateformRepository;

@Service
@Transactional
public class PlateformService implements IPlateformService{

	@Autowired
	private PlateformRepository plateformRepository;
	
	//CREATE
	@Override
	public Plateform getPlateform(Long id) throws NotFoundException {
		// TODO Auto-generated method stub
		return plateformRepository.findById(id).get();
	}

	@Override
	public List<Plateform> getPlateforms() {
		// TODO Auto-generated method stub
		return plateformRepository.findAll();
	}
	
	//CREATE
	@Override
	public Plateform save(Plateform plateform) {
		// TODO Auto-generated method stub
		return plateformRepository.save(plateform);
	}

	//DELETE
	@Override
	public void delete(Long id) throws NotFoundException {
		// TODO Auto-generated method stub
		try {
			plateformRepository.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			throw new NotFoundException();
		}
	}

	
}
