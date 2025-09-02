package org.example.libraryrest.catalog.dtos;

import org.example.libraryrest.catalog.model.Edition;
import org.example.libraryrest.catalog.model.WorkType;

import java.util.List;

public record WorkDto (Long id, String title, WorkType workType, String authors, String details, String subjects, List<EditionDto> editions) {
}
