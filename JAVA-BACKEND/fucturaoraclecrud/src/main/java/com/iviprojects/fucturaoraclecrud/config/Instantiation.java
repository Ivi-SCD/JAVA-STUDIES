package com.iviprojects.fucturaoraclecrud.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.iviprojects.fucturaoraclecrud.entities.Book;
import com.iviprojects.fucturaoraclecrud.entities.Genre;
import com.iviprojects.fucturaoraclecrud.services.BookService;
import com.iviprojects.fucturaoraclecrud.services.GenreService;

@Configuration
public class Instantiation implements CommandLineRunner {
	
	@Autowired
	private BookService bookService;

	@Autowired
	private GenreService genreService;
	
	@Override
	public void run(String... args) throws Exception {
		
		Genre g1 = new Genre("Terror");
		Genre g2 = new Genre("Romance");
		Genre g3 = new Genre("Suspense");
		Genre g4 = new Genre("Policial");
	
		Book l1 = new Book("Frankestein", "Mary Shelley");
		Book l2 = new Book("It: A coisa", "Stephen King");
		Book l3 = new Book("Outsider", "Stephen King");
		
		l1.getGenres().addAll(Arrays.asList(g1,g2));
		l2.getGenres().addAll(Arrays.asList(g1));
		l3.getGenres().addAll(Arrays.asList(g1,g2,g3,g4));
		
		genreService.insertGenre(g1);
		genreService.insertGenre(g2);
		genreService.insertGenre(g3);
		genreService.insertGenre(g4);
		bookService.insertBook(l1);
		bookService.insertBook(l2);
		bookService.insertBook(l3);
		
		bookService.updateBookData(l3, new Book("Edgar Allan Poe: Volume 1", "Edgar Allan Poe"));
		bookService.updateBook(l3);
		
		l3.getGenres().clear();
		bookService.deleteBook(l3.getId());
		
		
	}
}