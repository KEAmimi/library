package org.example.libraryrest.catalog.model;

import jakarta.persistence.Entity;
import org.example.libraryrest.common.model.BaseEntity;

@Entity
public class Publisher extends BaseEntity {


    String name;
    String address;
    String contactInfo;

    public Publisher(String name, String address, String contactInfo) {
        this.name = name;
        this.address = address;
        this.contactInfo = contactInfo;
    }

    public Publisher() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }
}
