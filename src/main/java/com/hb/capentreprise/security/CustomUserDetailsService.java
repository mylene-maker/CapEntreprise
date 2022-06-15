package com.hb.capentreprise.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hb.capentreprise.entities.InternalRole;
import com.hb.capentreprise.entities.InternalUser;
import com.hb.capentreprise.repositories.GamerRepository;
import com.hb.capentreprise.repositories.ModeratorRepository;


@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private GamerRepository gamerRepository;
	
	@Autowired
	private ModeratorRepository moderatorRepository;
	

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String pseudo) throws UsernameNotFoundException {
		InternalUser user = moderatorRepository.findByPseudo(pseudo);
		InternalUser gamer = gamerRepository.findByPseudo(pseudo);
		if (user == null) {
			throw new UsernameNotFoundException(pseudo + " not found");
		}
		User userDetails = new User(user.getPseudo(), user.getPassword(), getGrantedAuthorities(user.getRoles()));

		return userDetails;
	}

	private Collection<? extends GrantedAuthority> getGrantedAuthorities(List<InternalRole> roles) {
		List<GrantedAuthority> authorities = new ArrayList<>();
		for (InternalRole role : roles) {
			authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
		}
		return authorities;
	}
	
	

}