package com.hb.capentreprise.service;

import java.util.List;

import com.hb.capentreprise.entities.Game;

public interface IGameService {
	
	public Game getGame(Long id);

	public List<Game> getGames();

	public Game save(Game game);

	public void delete(Long id);
}


