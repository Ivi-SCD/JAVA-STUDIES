package com.iviprojects.fucturaoraclecrud.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iviprojects.fucturaoraclecrud.entities.Genre;
import com.iviprojects.fucturaoraclecrud.repositories.GenreRepository;

@Service
public class GenreService {
	
	@Autowired
	GenreRepository genreRepository;
	
	public List <Genre> findAll() {
		return genreRepository.findAll();
	}
	 
	public Genre findById(Long id) {
		Optional <Genre> genre = genreRepository.findById(id);
		return genre.orElseThrow(() -> new ObjectNotFoundException(null , genre.get().getName()));
	}
	
	public Genre insertGenre(Genre genre) {
		return genreRepository.save(genre);
	}
	
	public void deleteGenre(Long id) {
		findById(id);
		genreRepository.deleteById(id);
	}
	
	public Genre updateUser(Genre newBook) {
		Optional <Genre> oldBook = genreRepository.findById(newBook.getId());
		updateGenreData(oldBook.get(), newBook);
		return genreRepository.save(oldBook.get());
	}
	
	public void updateGenreData(Genre oldGenre, Genre newGenre) {
		oldGenre.setName(newGenre.getName());
	}
}