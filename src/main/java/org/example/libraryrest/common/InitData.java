package org.example.libraryrest.common;

import org.example.libraryrest.catalog.model.Work;
import org.example.libraryrest.catalog.model.WorkType;
import org.example.libraryrest.catalog.repository.WorkRepository;
import org.example.libraryrest.catalog.service.WorkService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitData implements CommandLineRunner {

    private final WorkRepository workRepository;
    public InitData(WorkRepository workRepository) {
        this.workRepository = workRepository;
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


    }




}
