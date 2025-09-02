package org.example.libraryrest.catalog.dtos;

import org.example.libraryrest.catalog.model.Edition;
import org.example.libraryrest.catalog.model.Publisher;
import org.example.libraryrest.catalog.model.Work;

import java.util.ArrayList;
import java.util.List;


public class Mapper {

    //To DTO mappers
    public static WorkDto toDto(Work work) {
        List<EditionDto> editionDtos = new ArrayList<>();

        for (Edition edition : work.getEditions()) {
            editionDtos.add(toDto(edition));
        }

        return new WorkDto(work.getId(), work.getTitle(), work.getWorkType(), work.getAuthors(), work.getDetails(), work.getSubjects(), editionDtos);
    }

    public static EditionDto toDto(Edition edition) {
        PublisherDto publisherDto = toDto(edition.getPublisher());
        return new EditionDto(edition.getId(), edition.getEditionNumber(), edition.getReleaseYear(), edition.getFormat(), publisherDto);
    }

    public static PublisherDto toDto(Publisher publisher) {
        return new PublisherDto(publisher.getId(), publisher.getName(), publisher.getAddress(), publisher.getContactInfo());
    }


    //To entity Mappers
    public static Work toEntity(WorkDto workDto) {
        Work work = new Work();
        work.setDetails(workDto.details());
        work.setSubjects(workDto.subjects());
        work.setAuthors(workDto.authors());
        work.setTitle(workDto.title());
        work.setWorkType(workDto.workType());

        List<Edition> editions = new ArrayList<>();
        for (EditionDto editionDto : workDto.editions()) {
            editions.add(toEntity(editionDto));
        }

        return work;
    }

    public static Edition toEntity(EditionDto editionDto) {
        Edition edition = new Edition();
        edition.setEditionNumber(editionDto.editionNumber());
        edition.setReleaseYear(editionDto.releaseYear());
        edition.setFormat(editionDto.format());
        edition.setFormat(editionDto.format());
        edition.setPublisher(toEntity(editionDto.publisher()));

        return edition;
    }

    public static Publisher toEntity(PublisherDto publisherDto) {
        Publisher publisher = new Publisher();
        publisher.setName(publisherDto.name());
        publisher.setAddress(publisherDto.address());
        publisher.setContactInfo(publisherDto.contactInfo());
        return publisher;
    }
}
