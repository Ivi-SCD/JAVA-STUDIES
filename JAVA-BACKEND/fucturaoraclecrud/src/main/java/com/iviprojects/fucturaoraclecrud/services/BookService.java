package com.iviprojects.fucturaoraclecrud.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iviprojects.fucturaoraclecrud.entities.Book;
import com.iviprojects.fucturaoraclecrud.repositories.BookRepository;

@Service
public class BookService {
	
	@Autowired
	BookRepository bookRepository;
	
	public List<Book> findAll() {
		return bookRepository.findAll();
	}
	 
	public Book findById(Long id) {
		Optional <Book> book = bookRepository.findById(id);
		return book.orElseThrow(() -> new ObjectNotFoundException(null , book.get().getTitulo()));
	}
	
	public Book insertBook(Book book) {
		return bookRepository.save(book);
	}
	
	public void deleteBook(Long id) {
		findById(id);
		bookRepository.deleteById(id);
	}
	
	public Book updateBook(Book newBook) {
		Optional <Book> oldBook = bookRepository.findById(newBook.getId());
		updateBookData(oldBook.get(), newBook);
		return bookRepository.save(oldBook.get());
	}
	
	public void updateBookData(Book oldBook, Book newBook) {
		oldBook.setAuthor(newBook.getAuthor());
		oldBook.setTitulo(newBook.getTitulo());
	}
}