package com.hb.capentreprise.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Classification {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "classification_id")
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@OneToMany(mappedBy = "classification", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Game> games = new ArrayList<Game>();

	
	public Classification() {
		super();
	}
	
	public Classification( String name) {
		super();
	
		this.name = name;
	
	}

	public Classification(Long id, String name, List<Game> games) {
		super();
		this.id = id;
		this.name = name;
		this.games = games;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Game> getGames() {
		return games;
	}

	public void setGames(List<Game> games) {
		this.games = games;
	}

	@Override
	public String toString() {
		return "Classification [id=" + id + ", name=" + name + "]";
	}

	
}
