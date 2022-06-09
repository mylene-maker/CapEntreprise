package com.hb.capentreprise.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hb.capentreprise.entities.Classification;
import com.hb.capentreprise.entities.Genre;
import com.hb.capentreprise.repositories.GenreRepository;

@Service
@Transactional
public class GenreService implements IGenreService{

	
	@Autowired 
	private GenreRepository genreRepository;
	
	@Override
	public Genre getGenre(Long id) {
		Genre genre = genreRepository.findById(id).get();
		return genre;
	}

	@Override
	public List<Genre> getGenres() {
		Iterable<Genre> genres = genreRepository.findAll();
		return (List<Genre>) genres;
	}

	@Override
	public Genre save(Genre genre) {
		genre = genreRepository.save(genre);
		return genre;
	}

	@Override
	public void delete(Long id) {
		genreRepository.deleteById(id);
		
	}

}
