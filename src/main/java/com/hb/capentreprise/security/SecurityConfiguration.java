package com.hb.capentreprise.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.authentication.logout.DelegatingServerLogoutHandler;
import org.springframework.security.web.server.authentication.logout.SecurityContextServerLogoutHandler;
import org.springframework.security.web.server.authentication.logout.WebSessionServerLogoutHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.util.UrlPathHelper;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private CustomUserDetailsService userDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		
		// setting service to find user in database and setting passwordEncoder
		
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
		
		// Creation of identifiers
		
//		auth.inMemoryAuthentication()
//		.withUser("jo").password(passwordEncoder().encode("jo")).roles("USER")
//		.and()
//		.withUser("ad").password(passwordEncoder().encode("ad")).roles("ADMIN", "USER");
	}
	
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		
		//Locks access according to roles
		
		http.authorizeRequests()
		

		.antMatchers("/registration").permitAll()
		.antMatchers("/review", "/", "/review/new", "/game").hasAnyRole("USER", "ADMIN")
		.antMatchers( "/review/*", "/game/new").hasRole("ADMIN")
		.and()
		.formLogin().loginPage("/login").permitAll().defaultSuccessUrl("/review",true)
		.and()
		.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login")
		.and()
		//Remenber-me config
		.rememberMe().tokenRepository(this.persistentTokenRepository())
		.tokenValiditySeconds(1*24*60*60); // valid for 24h
				
	}

	
	@Bean 
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
		}
	
	@Bean 
	public PersistentTokenRepository persistentTokenRepository() {
		//token stored in Memory of web server (remember-me)
		InMemoryTokenRepositoryImpl memory = new InMemoryTokenRepositoryImpl();
		return memory;
		
	}
	

	
}