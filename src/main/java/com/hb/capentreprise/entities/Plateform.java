package com.hb.capentreprise.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Plateform {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "plateform_id")
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@ManyToMany(mappedBy = "plateforms")
	private List<Game> games = new ArrayList<Game>();

	public Plateform() {
		
	}
	public Plateform(Long id, String name, List<Game> games) {
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
		return "Plateform [id=" + id + ", name=" + name + "]";
	}
	
}
