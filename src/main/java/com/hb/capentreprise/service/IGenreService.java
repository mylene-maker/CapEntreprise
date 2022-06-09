package com.hb.capentreprise.service;

import java.util.List;

import com.hb.capentreprise.entities.Genre;

public interface IGenreService {

	public Genre getGenre(Long id);

	public List<Genre> getGenres();

	public Genre save(Genre genre);

	public void delete(Long id);
}
