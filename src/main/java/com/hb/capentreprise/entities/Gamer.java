package com.hb.capentreprise.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Gamer extends InternalUser {
	
	@Column(nullable = false)
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
