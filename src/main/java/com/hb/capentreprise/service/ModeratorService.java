package com.hb.capentreprise.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.hb.capentreprise.entities.Moderator;
import com.hb.capentreprise.repositories.ModeratorRepository;

@Service
public class ModeratorService implements IModeratorService {
	
	@Autowired
	private ModeratorRepository moderatorRepo;

	@Override
	public Moderator getModerator(Long id) {
		Moderator moderator = moderatorRepo.findById(id).get();
		return moderator;
	}

	@Override
	public List<Moderator> getModerators() {
		List<Moderator> moderators = moderatorRepo.findAll();
		return moderators;
	}

	@Override
	public Moderator save(Moderator moderator) {
		Moderator moderatorSaved = moderatorRepo.save(moderator);
		return moderatorSaved;
	}

	@Override
	public void delete(Long id) {
		moderatorRepo.deleteById(id);
		
	}
	
	@Override
	public Moderator findByPseudo(String pseudo) {
		Moderator moderator = moderatorRepo.findByPseudo(pseudo);
		return moderator;
	}

	@Override
	public Moderator getCurrentModerator() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = "";
		if (principal instanceof UserDetails) {
			  username = ((UserDetails)principal).getUsername();
			} else {
			 username = principal.toString();
			}
		Moderator moderator = this.findByPseudo(username);
		
		return moderator;
	}

	

}
