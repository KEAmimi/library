package org.example.libraryrest.catalog.model;

import jakarta.persistence.*;

@Entity
public class Edition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String editionNumber;
    int releaseYear;
    String format;

    @ManyToOne
    private Publisher publisher;

    @ManyToOne
    private Work work;

    public Edition(Long id, String editionNumber, int releaseYear, String format, Publisher publisher, Work work) {
        this.id = id;
        this.editionNumber = editionNumber;
        this.releaseYear = releaseYear;
        this.format = format;
        this.publisher = publisher;
        this.work = work;
    }

    public Edition() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEditionNumber() {
        return editionNumber;
    }

    public void setEditionNumber(String editionNumber) {
        this.editionNumber = editionNumber;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Work getWork() {
        return work;
    }

    public void setWork(Work work) {
        this.work = work;
    }
}
