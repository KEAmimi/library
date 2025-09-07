package org.example.libraryrest.catalog.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import org.example.libraryrest.common.model.BaseEntity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Author extends BaseEntity {
    private String name;

    @ManyToMany(mappedBy = "authors")
    @JsonManagedReference
    private Set<Work> works = new HashSet<>();

    public Author(String name) {
        this.name = name;
    }

    public Author() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    //Work syncing
    public Set<Work> getWorks() {
        return works;
    }

    public void addWork(Work work) {
        works.add(work);
    }

    public void removeWork(Work work) {
        works.remove(work);
    }

}
