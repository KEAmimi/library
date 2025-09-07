package org.example.libraryrest.catalog.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import org.example.libraryrest.common.model.BaseEntity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Work extends BaseEntity {


    String title;

    @Enumerated(EnumType.STRING)
    WorkType workType;
    String details;

    @OneToMany(mappedBy = "work", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    List<Edition> editions = new ArrayList<>();

    @ManyToMany
    Set<Subject> subjects = new HashSet<>();

    @ManyToMany
    @JsonBackReference
    Set<Author> authors = new HashSet<>();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public WorkType getWorkType() {
        return workType;
    }

    public void setWorkType(WorkType workType) {
        this.workType = workType;
    }


    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }


    public Work(String title, WorkType workType, Set<Author> authors, String details, Set<Subject> subjects) {
        this.title = title;
        this.workType = workType;
        this.authors = authors;
        this.details = details;
        this.subjects = subjects;
    }

    public Work() {
    }

    //Edition Management

    public void addEdition(Edition edition) {
        this.editions.add(edition);
        edition.setWork(this);
    }

    public void removeEdition(Edition edition) {
        this.editions.remove(edition);
        edition.setWork(null);
    }

    public List<Edition> getEditions() {
        return editions;
    }

    public void removeEditions() {
        for (Edition edition : editions) {
            edition.setWork(null);
        }
        this.editions.clear();
    }

    //Author management, synchronicity required

    public Set<Author> getAuthors() {
        return authors;
    }

    public void addAuthor(Author author) {
        this.authors.add(author);
        author.addWork(this);
    }
    public void removeAuthor(Author author) {
        this.authors.remove(author);
        author.removeWork(this);
    }
    public void clearAuthors() {
        this.authors.clear();
        for (Author author : authors) {
            author.removeWork(this);
        }
    }

    //Subject management. No Synchronisity required


    public Set<Subject> getSubjects() {
        return subjects;
    }

    public void addSubject(Subject subject) {
        this.subjects.add(subject);
    }

    public void removeSubject(Subject subject) {
        this.subjects.remove(subject);
    }

    public void clearSubjects() {
        this.subjects.clear();
    }


}
