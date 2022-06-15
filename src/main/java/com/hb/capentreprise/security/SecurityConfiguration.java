package com.hb.capentreprise.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

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
		
		/*auth.inMemoryAuthentication()
		.withUser("Mylene").password(passwordEncoder().encode("saidousseni")).roles("USER")
		.and()
		.withUser("useradmin").password(passwordEncoder().encode("admin123")).roles("ADMIN", "USER");*/
	}
	
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		
		//Locks access according to roles
		
		http.authorizeRequests()
		
		.antMatchers("/inscription").permitAll()
		.antMatchers("/review", "/game").hasAnyRole("USER", "ADMIN")
		.antMatchers( "/review/delete", "/addGame").hasRole("ADMIN")
		.and()
		.formLogin().loginPage("/login").permitAll().defaultSuccessUrl("/review",true)
		.and()
		.logout().permitAll()
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