package com.iviprojects.fucturaoraclecrud.config;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.iviprojects.fucturaoraclecrud.entities.Book;
import com.iviprojects.fucturaoraclecrud.entities.Genre;
import com.iviprojects.fucturaoraclecrud.repositories.BookRepository;
import com.iviprojects.fucturaoraclecrud.repositories.GenreRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	
	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private GenreRepository genreRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Genre g1 = new Genre("Terror");
		Genre g2 = new Genre("Romance");
		Genre g3 = new Genre("Suspense");
		Genre g4 = new Genre("Policial");
		
		genreRepository.saveAll(Arrays.asList(g1,g2,g3,g4));
		
		Book l1 = new Book("Frankestein", "Mary Shelley", new HashSet<>(Arrays.asList(g1,g3)));
		Book l2 = new Book("It: A coisa", "Stephen King", new HashSet<>(Arrays.asList(g1)));
		Book l3 = new Book("Outsider", "Stephen King", new HashSet<>(Arrays.asList(g1,g2,g3,g4)));
		
		bookRepository.saveAll(Arrays.asList(l1,l2,l3));
	}
}