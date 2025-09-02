package org.example.libraryrest.catalog.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "works")
public class Work {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String title;
    WorkType workType;
    String authors;
    String details;
    String subjects;

    @OneToMany(mappedBy = "work", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    List<Edition> editions = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getSubjects() {
        return subjects;
    }

    public void setSubjects(String subjects) {
        this.subjects = subjects;
    }

    public Work(Long id, String title, WorkType workType, String authors, String details, String subjects) {
        this.id = id;
        this.title = title;
        this.workType = workType;
        this.authors = authors;
        this.details = details;
        this.subjects = subjects;
    }

    public Work() {
    }

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
        this.editions.clear();
        for (Edition edition : editions) {
            edition.setWork(null);
        }
    }
}
