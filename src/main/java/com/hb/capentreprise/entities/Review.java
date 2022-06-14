package com.hb.capentreprise.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Review {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "review_id")
	private Long id;
	
	@Column(nullable = false)
	private String description;
	
	@Column(nullable = false)
	private LocalDate sendDate;
	
	@Column(nullable = false)
	private Float note;
	
	@Column(nullable = false)
	private LocalDate moderationDate;
	
	
	@ManyToOne
	@JoinColumn(name = "game_id")
	private Game game;
	
	@ManyToOne
	@JoinColumn(name = "gamer_id")
	private Gamer gamer;
	
	@ManyToOne
	@JoinColumn(name = "moderator_id")
	private Moderator moderator;

	public Review() {
		super();
	}
	
	public Review( String description, LocalDate sendDate, Float note, LocalDate moderationDate) {
		super();
		
		this.description = description;
		this.sendDate = sendDate;
		this.note = note;
		this.moderationDate = moderationDate;
	
	}

	public Review(Long id, String description, LocalDate sendDate, Float note, LocalDate moderationDate, Game game,
			Gamer gamer, Moderator moderator) {
		super();
		this.id = id;
		this.description = description;
		this.sendDate = sendDate;
		this.note = note;
		this.moderationDate = moderationDate;
		this.game = game;
		this.gamer = gamer;
		this.moderator = moderator;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getSendDate() {
		return sendDate;
	}

	public void setSendDate(LocalDate sendDate) {
		this.sendDate = sendDate;
	}

	public Float getNote() {
		return note;
	}

	public void setNote(Float note) {
		this.note = note;
	}

	public LocalDate getModerationDate() {
		return moderationDate;
	}

	public void setModerationDate(LocalDate moderationDate) {
		this.moderationDate = moderationDate;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public Gamer getGamer() {
		return gamer;
	}

	public void setGamer(Gamer gamer) {
		this.gamer = gamer;
	}

	public Moderator getModerator() {
		return moderator;
	}

	public void setModerator(Moderator moderator) {
		this.moderator = moderator;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", description=" + description + ", sendDate=" + sendDate + ", note=" + note
				+ ", moderationDate=" + moderationDate + "]";
	}
	
	
}
