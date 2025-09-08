package org.example.libraryrest.catalog.service;

import org.example.libraryrest.catalog.model.Author;
import org.example.libraryrest.catalog.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author saveIfNotExists(Author author) {
        Optional<Author> optionalAuthor = authorRepository.findById(author.getId());
        if (optionalAuthor.isPresent()) {
            if (optionalAuthor.get().getName().equals(author.getName())) { //The Authors details match the ones in the database already - We are confident they are the same
                return authorRepository.save(optionalAuthor.get());
            }
            else { //The details do not match, so we save a new author instead
                author.setId(null);
                return authorRepository.save(author);
            }
        }
        else {
            author.setId(null);
            return authorRepository.save(author);
        }
    }
}
