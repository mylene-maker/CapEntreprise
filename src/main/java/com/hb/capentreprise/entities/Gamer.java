package com.hb.capentreprise.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Gamer extends InternalUser {
	
	@Column(nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate birthdate;
	
	@OneToMany(mappedBy = "gamer", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Review> reviews = new ArrayList<Review>();


	public Gamer() {
		
	}

	public Gamer(LocalDate birthdate, List<Review> reviews) {
		super();
		this.birthdate = birthdate;
		this.reviews = reviews;
	}

	public Gamer(String email, String password, String pseudo, LocalDate birthdate, List<InternalRole> asList) {
		// TODO Auto-generated constructor stub
		this.email = email;
		this.password = password;
		this.pseudo = pseudo;
		this.birthdate = birthdate;
		this.roles = asList;
	}

	public LocalDate getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	@Override
	public String toString() {
		return "Gamer [birthdate=" + birthdate + "]";
	}
	
	
	
	

}
