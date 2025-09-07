package org.example.libraryrest.catalog.dtos;

import org.example.libraryrest.catalog.model.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Mapper {

    //To DTO mappers
    public static WorkDto toDto(Work work) {
        List<EditionDto> editionDtos = new ArrayList<>();
        for (Edition edition : work.getEditions()) {
            editionDtos.add(toDto(edition));
        }

        Set<AuthorDto> authorDtos = new HashSet<>();
        for (Author author : work.getAuthors()) {
            authorDtos.add(toDto(author));
        }

        Set<SubjectDto> subjectDtos = new HashSet<>();
        for (Subject subject : work.getSubjects()) {
            subjectDtos.add(toDto(subject));
        }

        return new WorkDto(work.getId(), work.getTitle(), work.getWorkType(), authorDtos, work.getDetails(), subjectDtos, editionDtos);
    }

    //Edition to DTO
    public static EditionDto toDto(Edition edition) {
        PublisherDto publisherDto = toDto(edition.getPublisher());
        return new EditionDto(edition.getId(), edition.getEditionNumber(), edition.getReleaseYear(), edition.getFormat(), publisherDto);
    }

    //Publisher to DTO
    public static PublisherDto toDto(Publisher publisher) {
        return new PublisherDto(publisher.getId(), publisher.getName(), publisher.getAddress(), publisher.getContactInfo());
    }

    //Author to DTO
    public static AuthorDto toDto(Author author) {
        return new AuthorDto(author.getId(), author.getName());
    }

    //Subject to DTO
    public static SubjectDto toDto(Subject subject) {
        return new SubjectDto(subject.getId(), subject.getName());
    }


    //To entity Mappers
    public static Work toEntity(WorkDto workDto) {
        Work work = new Work();
        work.setDetails(workDto.details());
        work.setTitle(workDto.title());
        work.setWorkType(workDto.workType());

        //Editions to entities
        for (EditionDto editionDto : workDto.editions()) {
            work.addEdition(toEntity(editionDto));
        }

        //Map Authors to Entity
        for (AuthorDto authorDto : workDto.authors()) {
            work.addAuthor(toEntity(authorDto));
        }

        //Map Subject to entity
        for (SubjectDto subjectDto : workDto.subjects()) {
            work.addSubject(toEntity(subjectDto));
        }

        return work;
    }

    //Edition to Entity
    public static Edition toEntity(EditionDto editionDto) {
        Edition edition = new Edition();
        edition.setEditionNumber(editionDto.editionNumber());
        edition.setReleaseYear(editionDto.releaseYear());
        edition.setFormat(editionDto.format());
        edition.setFormat(editionDto.format());
        edition.setPublisher(toEntity(editionDto.publisher()));

        return edition;
    }

    //Publisher to Entity
    public static Publisher toEntity(PublisherDto publisherDto) {
        Publisher publisher = new Publisher();
        publisher.setName(publisherDto.name());
        publisher.setAddress(publisherDto.address());
        publisher.setContactInfo(publisherDto.contactInfo());
        return publisher;
    }

    //Author to Entity
    public static Author toEntity(AuthorDto authorDto) {
        Author author = new Author();
        author.setName(authorDto.name());
        return author;
    }

    //Subject to Entity
    public static Subject toEntity(SubjectDto subjectDto) {
        Subject subject = new Subject();
        subject.setName(subjectDto.name());
        return subject;
    }
}
