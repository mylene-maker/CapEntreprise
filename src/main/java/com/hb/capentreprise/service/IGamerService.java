package com.hb.capentreprise.service;

import java.util.List;

import com.hb.capentreprise.entities.Gamer;


public interface IGamerService {
	public Gamer getGamer(Long id);

	public List<Gamer> getGamers();

	public Gamer save(Gamer gamer);

	public void delete(Long id);
}
