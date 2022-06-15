package com.hb.capentreprise.service;

import java.util.Arrays;
import java.util.List;

import javax.management.relation.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hb.capentreprise.entities.Gamer;
import com.hb.capentreprise.entities.InternalRole;
import com.hb.capentreprise.repositories.GamerRepository;
import com.hb.capentreprise.security.CustomUserDetailsService;

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
		
		Gamer gamerSaved = new Gamer(gamer.getEmail(), new BCryptPasswordEncoder().encode(gamer.getPassword()), gamer.getPseudo(),
				gamer.getBirthdate(), Arrays.asList(new InternalRole(2, "ROLE_USER")));
		
		return gamerRepo.save(gamerSaved);
	}

	@Override
	public void delete(Long id) {
		int i=id.intValue();
		gamerRepo.deleteById(i);
		
	}

	@Override
	public Gamer getGamerByPseudo(String pseudo) {
		Gamer gamer = gamerRepo.getGamerByPseudo(pseudo);
		return gamer;
	}
	
	public Gamer getCurrentGamer() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = "";
		if (principal instanceof UserDetails) {
			  username = ((UserDetails)principal).getUsername();
			} else {
			 username = principal.toString();
			}
		Gamer gamer = this.getGamerByPseudo(username);
		
		return gamer;
	}

}
