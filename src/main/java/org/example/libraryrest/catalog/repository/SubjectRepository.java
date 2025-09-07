package org.example.libraryrest.catalog.repository;

import org.example.libraryrest.catalog.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
