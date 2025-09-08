package org.example.libraryrest.catalog.service;

import org.example.libraryrest.catalog.model.Subject;
import org.example.libraryrest.catalog.repository.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SubjectService {
    private final SubjectRepository subjectRepository;
    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public Subject saveIfNotExists(Subject subject) {
        Optional<Subject> optionalSubject = subjectRepository.findById(subject.getId());
        if (optionalSubject.isPresent()) {
            if (optionalSubject.get().getName().equals(subject.getName())) {
                return subjectRepository.save(optionalSubject.get());
            }
            else {
                subject.setId(null);
                return subjectRepository.save(subject);
            }
        }
        else {
            subject.setId(null);
            return subjectRepository.save(subject);
        }
    }
}
