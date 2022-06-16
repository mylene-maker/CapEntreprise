package com.hb.capentreprise.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
public class Review {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "review_id")
	private Long id;
	
	@NotEmpty(message = "Description is mandatory")
	@Size(min = 10, max = 100)
	@Column(nullable = false)
	private String description;
	
	@Column(nullable = false)
	private LocalDate sendDate = LocalDate.now();
	
	@NotNull(message = "Note is mandatory")
	@Min(value = 0, message = "must be greater than or equal to zero")
	@Max(value = 10, message = "must be less than or equal to 10")
	@Column(nullable = false)
	private Float note;
	
	@Column(nullable = true)
	private LocalDate moderationDate;
	
	@NotNull(message = "Game is mandatory")
	@ManyToOne
	@JoinColumn(name = "game_id")
	private Game game;
	
	@NotNull(message = "Gamer is mandatory")
	@ManyToOne
	@JoinColumn(name = "gamer_id")
	private Gamer gamer;
	
	@ManyToOne
	@JoinColumn(name = "moderator_id")
	private Moderator moderator;

	public Review() {
		super();
	}
	
	public Review( String description, Float note, LocalDate moderationDate) {
		super();
		
		this.description = description;
		this.note = note;
		this.moderationDate = moderationDate;
	
	}

	public Review(Long id, String description,Float note, LocalDate moderationDate, Game game,
			Gamer gamer, Moderator moderator) {
		super();
		this.id = id;
		this.description = description;
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
