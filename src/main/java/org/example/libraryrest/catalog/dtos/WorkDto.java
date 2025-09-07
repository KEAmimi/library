package org.example.libraryrest.catalog.dtos;

import org.example.libraryrest.catalog.model.Author;
import org.example.libraryrest.catalog.model.Edition;
import org.example.libraryrest.catalog.model.Subject;
import org.example.libraryrest.catalog.model.WorkType;

import java.util.List;
import java.util.Set;

public record WorkDto (Long id, String title, WorkType workType, Set<AuthorDto> authors, String details, Set<SubjectDto> subjects, List<EditionDto> editions) {
}
