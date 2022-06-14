package com.hb.capentreprise.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hb.capentreprise.entities.Game;
import com.hb.capentreprise.repositories.GameRepository;

@Service
public class GameService implements IGameService {
	
	@Autowired
	private GameRepository gameRepo;

	@Override
	public Game getGame(Long id) {
		long i=id.intValue();
		Game game = gameRepo.findById(i).get();
		return game;
	}

	@Override
	public List<Game> getGames() {
		List<Game> games = gameRepo.findAll();
		return games;
	}

	@Override
	public Game save(Game game) {
		Game gameSaved = gameRepo.save(game);
		return gameSaved;
	}

	@Override
	public void delete(Long id) {
		long i=id.intValue();
		gameRepo.deleteById(i);
		
	}

}
