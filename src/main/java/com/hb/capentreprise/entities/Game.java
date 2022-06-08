package com.hb.capentreprise.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Game {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "game_id")
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String description;
	
	@Column(nullable = false)
	private LocalDate releaseDate;
	
	@Column(nullable = false)
	private String picture;
	
	@ManyToOne
	@JoinColumn(name = "genre_id")
	private Genre genre;
	
	@ManyToOne
	@JoinColumn(name = "classification_id")
	private Classification classifaction;
	
	@OneToMany(mappedBy = "game", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Review> reviews = new ArrayList<Review>();
	
	@ManyToOne
	@JoinColumn(name = "economicModel_id")
	private EconomicModel economicModel;
	
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(joinColumns = @JoinColumn(name = "game_id"), inverseJoinColumns = @JoinColumn(name = "plateform_id"))
	private List<Plateform> plateforms = new ArrayList<Plateform>();
	
	@ManyToOne
	@JoinColumn(name = "editor_id")
	private Editor editor;
	
	@ManyToOne
	@JoinColumn(name = "moderator_id")
	private Moderator moderator;

	public Game() {
		
	}
	
	public Game(Long id, String name, String description, LocalDate releaseDate, String picture, Genre genre,
			Classification classifaction, List<Review> reviews, EconomicModel economicModel, List<Plateform> plateforms,
			Editor editor, Moderator moderator) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.releaseDate = releaseDate;
		this.picture = picture;
		this.genre = genre;
		this.classifaction = classifaction;
		this.reviews = reviews;
		this.economicModel = economicModel;
		this.plateforms = plateforms;
		this.editor = editor;
		this.moderator = moderator;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public Classification getClassifaction() {
		return classifaction;
	}

	public void setClassifaction(Classification classifaction) {
		this.classifaction = classifaction;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public EconomicModel getEconomicModel() {
		return economicModel;
	}

	public void setEconomicModel(EconomicModel economicModel) {
		this.economicModel = economicModel;
	}

	public List<Plateform> getPlateforms() {
		return plateforms;
	}

	public void setPlateforms(List<Plateform> plateforms) {
		this.plateforms = plateforms;
	}

	public Editor getEditor() {
		return editor;
	}

	public void setEditor(Editor editor) {
		this.editor = editor;
	}

	public Moderator getModerator() {
		return moderator;
	}

	public void setModerator(Moderator moderator) {
		this.moderator = moderator;
	}

	@Override
	public String toString() {
		return "Game [id=" + id + ", name=" + name + ", description=" + description + ", releaseDate=" + releaseDate
				+ ", picture=" + picture + ", moderator=" + moderator + "]";
	}
	
		
	
}
