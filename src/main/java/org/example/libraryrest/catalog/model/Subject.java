package org.example.libraryrest.catalog.model;

import jakarta.persistence.Entity;
import org.example.libraryrest.common.model.BaseEntity;

@Entity
public class Subject extends BaseEntity {
    private String name;

    public Subject(String name) {
        this.name = name;
    }

    public Subject() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
