package org.example.libraryrest.catalog.repository;

import org.example.libraryrest.catalog.model.Edition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EditionRepository extends JpaRepository<Edition, Long> {
}
