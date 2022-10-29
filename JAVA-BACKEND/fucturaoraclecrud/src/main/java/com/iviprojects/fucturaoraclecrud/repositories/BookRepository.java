package com.iviprojects.fucturaoraclecrud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iviprojects.fucturaoraclecrud.entities.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}