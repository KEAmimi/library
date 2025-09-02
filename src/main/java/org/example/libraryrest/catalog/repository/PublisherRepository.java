package org.example.libraryrest.catalog.repository;

import org.example.libraryrest.catalog.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {
}
