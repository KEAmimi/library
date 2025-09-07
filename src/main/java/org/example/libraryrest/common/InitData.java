package org.example.libraryrest.common;

import org.example.libraryrest.catalog.model.*;
import org.example.libraryrest.catalog.repository.*;
import org.example.libraryrest.catalog.service.WorkService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InitData implements CommandLineRunner {

    private final WorkRepository workRepository;
    private final EditionRepository editionRepository;
    private final PublisherRepository publisherRepository;
    private final SubjectRepository subjectRepository;
    private final AuthorRepository authorRepository;

    public InitData(WorkRepository workRepository, EditionRepository editionRepository, PublisherRepository publisherRepository, SubjectRepository subjectRepository, AuthorRepository authorRepository) {
        this.workRepository = workRepository;
        this.editionRepository = editionRepository;
        this.publisherRepository = publisherRepository;
        this.subjectRepository = subjectRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author auth1 = new Author();
        auth1.setName("Mikkel");
        Author auth2 = new Author();
        auth2.setName("Caroline");
        Author auth3 = new Author();
        auth3.setName("David");
        Author auth4 = new Author();
        auth4.setName("Jack");
        authorRepository.saveAll(List.of(auth1, auth2, auth3, auth4));

        Subject sub1 = new Subject();
        sub1.setName("Comedy");
        Subject sub2 = new Subject();
        sub2.setName("Science");
        Subject sub3 = new Subject();
        sub3.setName("Biology");
        Subject sub4 = new Subject();
        sub4.setName("Horror");
        subjectRepository.saveAll(List.of(sub1, sub2, sub3, sub4));


        Work work1 = new Work();
        work1.setTitle("Work 1");
        work1.setWorkType(WorkType.BOOK);
        work1.addAuthor(auth1);
        work1.addAuthor(auth2);
        work1.setDetails("The first work");
        work1.addSubject(sub1);
        work1.addSubject(sub2);

        Work work2 = new Work();
        work2.setTitle("Work 2");
        work2.setWorkType(WorkType.MAGAZINE);
        work2.addAuthor(auth3);
        work2.addAuthor(auth4);
        work2.setDetails("The Second work");
        work2.addSubject(sub3);

        Work work3 = new Work();
        work3.setTitle("Work 3");
        work3.setWorkType(WorkType.ARTICLE);
        work3.addAuthor(auth4);
        work3.setDetails("The Third work");
        work3.addSubject(sub4);
        work3.addSubject(sub2);
        work3.addSubject(sub1);

        Work work4 = new Work();
        work4.setTitle("Work 4");
        work4.setWorkType(WorkType.BOOK);
        work4.addAuthor(auth1);
        work4.setDetails("The fourth work");
        work4.addSubject(sub1);

        Work work5 = new Work();
        work5.setTitle("Work 5");
        work5.setWorkType(WorkType.MAGAZINE);
        work5.addAuthor(auth1);
        work5.addAuthor(auth2);
        work5.addAuthor(auth3);
        work5.addAuthor(auth4);
        work5.setDetails("The final work");
        work5.addSubject(sub1);
        work5.addSubject(sub2);
        work5.addSubject(sub3);
        work5.addSubject(sub4);


        workRepository.save(work1);
        workRepository.save(work2);
        workRepository.save(work3);
        workRepository.save(work4);
        workRepository.save(work5);

        Publisher pub1 = new Publisher("Mikkel Publishing", "Bookway 1", "CallMeMaybe");
        Publisher pub2 = new Publisher("Caroline Publishing", "Bookway 2", "Don'tCallMe");

        publisherRepository.save(pub1);
        publisherRepository.save(pub2);

        Edition ed1 = new Edition("Abc123", 2023, "Hard cover", pub1, work1);
        Edition ed2 = new Edition("Abc123", 2023, "Soft cover", pub2, work2);
        Edition ed3 = new Edition("Abc123", 2023, "Leather cover", pub1, work3);
        Edition ed4 = new Edition("Abc123", 2023, "Wood cover", pub2, work1);
        Edition ed5 = new Edition("Abc123", 2023, "ToiletPaper cover", pub1, work2);
        Edition ed6 = new Edition("Abc123", 2023, "ToiletPaper cover", pub1, work4);
        Edition ed7 = new Edition("Abc123", 2023, "ToiletPaper cover", pub2, work5);

        work1.addEdition(ed1);
        work1.addEdition(ed4);
        work2.addEdition(ed5);
        work2.addEdition(ed2);
        work3.addEdition(ed3);
        work4.addEdition(ed6);
        work5.addEdition(ed7);

        editionRepository.save(ed1);
        editionRepository.save(ed2);
        editionRepository.save(ed3);
        editionRepository.save(ed4);
        editionRepository.save(ed5);
        editionRepository.save(ed6);
        editionRepository.save(ed7);

    }



}
