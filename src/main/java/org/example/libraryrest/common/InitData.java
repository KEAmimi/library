package org.example.libraryrest.common;

import org.example.libraryrest.catalog.model.Edition;
import org.example.libraryrest.catalog.model.Publisher;
import org.example.libraryrest.catalog.model.Work;
import org.example.libraryrest.catalog.model.WorkType;
import org.example.libraryrest.catalog.repository.EditionRepository;
import org.example.libraryrest.catalog.repository.PublisherRepository;
import org.example.libraryrest.catalog.repository.WorkRepository;
import org.example.libraryrest.catalog.service.WorkService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitData implements CommandLineRunner {

    private final WorkRepository workRepository;
    private final EditionRepository editionRepository;
    private final PublisherRepository publisherRepository;
    public InitData(WorkRepository workRepository, EditionRepository editionRepository, PublisherRepository publisherRepository) {
        this.workRepository = workRepository;
        this.editionRepository = editionRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Work work1 = new Work(
                null,
                "Lord of the Drinks",
                WorkType.BOOK,
                "John Drinker",
                "A humorous take on fantasy literature, but with drinks.",
                "Comedy"
        );

        Work work2 = new Work(
                null,
                "Test",
                WorkType.MAGAZINE,
                "Editorial Team",
                "A monthly magazine covering the latest in science and technology.",
                "Science"
        );

        Work work3 = new Work(
                null,
                "History of Brewing",
                WorkType.BOOK,
                "Mary Brewer",
                "An in-depth book about the history of brewing across cultures.",
                "History"
        );

        Work work4 = new Work(
                null,
                "Healthy Living",
                WorkType.ARTICLE,
                "Dr. Fit",
                "An article focused on nutrition and wellness for daily life.",
                "Health"
        );

        Work work5 = new Work(
                null,
                "Space Explorers",
                WorkType.BOOK,
                "Neil Stardust",
                "A book about humanity’s adventures beyond Earth.",
                "Science Fiction"
        );

        workRepository.save(work1);
        workRepository.save(work2);
        workRepository.save(work3);
        workRepository.save(work4);
        workRepository.save(work5);

        Publisher pub1 = new Publisher(null, "Mikkel Publishing", "Bookway 1", "CallMeMaybe");
        Publisher pub2 = new Publisher(null, "Caroline Publishing", "Bookway 2", "Don'tCallMe");

        publisherRepository.save(pub1);
        publisherRepository.save(pub2);

        Edition ed1 = new Edition(null, "Abc123", 2023, "Hard cover", pub1, work1);
        Edition ed2 = new Edition(null, "Abc123", 2023, "Soft cover", pub2, work2);
        Edition ed3 = new Edition(null, "Abc123", 2023, "Leather cover", pub1, work3);
        Edition ed4 = new Edition(null, "Abc123", 2023, "Wood cover", pub2, work1);
        Edition ed5 = new Edition(null, "Abc123", 2023, "ToiletPaper cover", pub1, work2);
        Edition ed6 = new Edition(null, "Abc123", 2023, "ToiletPaper cover", pub1, work4);
        Edition ed7 = new Edition(null, "Abc123", 2023, "ToiletPaper cover", pub2, work5);

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
