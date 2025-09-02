package org.example.libraryrest.catalog.dtos;

import org.example.libraryrest.catalog.model.Publisher;
import org.example.libraryrest.catalog.model.Work;

public record EditionDto(Long id, String editionNumber, int releaseYear, String format, PublisherDto publisher) {
}
