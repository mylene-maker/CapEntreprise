package com.hb.capentreprise.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hb.capentreprise.entities.Gamer;
import com.hb.capentreprise.repositories.GamerRepository;

@Service
public class GamerService implements IGamerService {
	
	@Autowired
	private GamerRepository gamerRepo;

	@Override
	public Gamer getGamer(Long id) {
		int i=id.intValue();
		Gamer gamer = gamerRepo.findById(i).get();
		return gamer;
	}

	@Override
	public List<Gamer> getGamers() {
		List<Gamer> gamers = gamerRepo.findAll();
		return gamers;
	}

	@Override
	public Gamer save(Gamer gamer) {
		Gamer gamerSaved = gamerRepo.save(gamer);
		return gamerSaved;
	}

	@Override
	public void delete(Long id) {
		int i=id.intValue();
		gamerRepo.deleteById(i);
		
	}

}
