package com.iviprojects.fucturaoraclecrud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iviprojects.fucturaoraclecrud.entities.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long> {

}