package org.example.libraryrest.catalog.repository;

import org.example.libraryrest.catalog.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
