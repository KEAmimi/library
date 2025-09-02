package org.example.libraryrest.catalog.service;

import org.example.libraryrest.catalog.model.Work;
import org.example.libraryrest.catalog.repository.WorkRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkService {
    private final WorkRepository workRepository;
    public WorkService(WorkRepository workRepository) {
        this.workRepository = workRepository;
    }

    //GetAllWorks
    public List<Work> getAllWorks(){
        return workRepository.findAll();
    }

    //Find work by ID (Long ID)
    public Work getWorkById(Long id){
        Optional<Work> work = workRepository.findById(id);
        if(work.isPresent()){
            return work.get();
        }
        throw new RuntimeException("Work not found with id " + id);
    }

    //Create Work (Work work)
    public Work createWork(Work work){
        work.setId(null);
        return workRepository.save(work);
    }

    public Work updateWork(Long id, Work work){
        Optional<Work> findWork = workRepository.findById(id);
        if(findWork.isPresent()){
            Work workToUpdate = findWork.get();
            workToUpdate.setWorkType(work.getWorkType());
            workToUpdate.setAuthors(work.getAuthors());
            workToUpdate.setTitle(work.getTitle());
            workToUpdate.setDetails(work.getDetails());
            workToUpdate.setSubjects(work.getSubjects());
            return workRepository.save(workToUpdate);
        }
        throw new RuntimeException("Work not found with id " + id);
    }

    public void deleteWork(Long id){
        workRepository.deleteById(id);
    }

    public List<Work> getWorksByTitle(String title){
        return workRepository.findByTitleContaining(title);
    }
}
