package com.hb.capentreprise.service;

import java.util.List;

import com.hb.capentreprise.entities.Moderator;

public interface IModeratorService {
	public Moderator getModerator(Long id);

	public List<Moderator> getModerators();

	public Moderator save(Moderator moderator);

	public void delete(Long id);
	
	public Moderator findByPseudo(String pseudo);
	
	public Moderator getCurrentModerator();
}
