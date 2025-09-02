package org.example.libraryrest.catalog.service;

import org.example.libraryrest.catalog.dtos.Mapper;
import org.example.libraryrest.catalog.dtos.WorkDto;
import org.example.libraryrest.catalog.model.Work;
import org.example.libraryrest.catalog.repository.WorkRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WorkService {
    private final WorkRepository workRepository;
    public WorkService(WorkRepository workRepository) {
        this.workRepository = workRepository;
    }


    //GetAllWorks
    public List<WorkDto> getAllWorks(){
        List<WorkDto> workDtos = new ArrayList<>();
        List<Work> works = workRepository.findAll();
        for (Work work : works) {
            workDtos.add(Mapper.toDto(work));
        }
        return workDtos;
    }

    //Find work by ID (Long ID)
    public WorkDto getWorkById(Long id){
        Optional<Work> work = workRepository.findById(id);
        if(work.isPresent()){
            return Mapper.toDto(work.get());
        }
        throw new RuntimeException("Work not found with id " + id);
    }

    //Create Work (Work work)
    public WorkDto createWork(WorkDto workDto){
        Work work = Mapper.toEntity(workDto);

        work.setId(null);
        return Mapper.toDto(workRepository.save(work));
    }

    public WorkDto updateWork(Long id, WorkDto workDto){
        Optional<Work> findWork = workRepository.findById(id);
        Work work = Mapper.toEntity(workDto);
        if(findWork.isPresent()){
            Work workToUpdate = findWork.get();
            workToUpdate.setWorkType(work.getWorkType());
            workToUpdate.setAuthors(work.getAuthors());
            workToUpdate.setTitle(work.getTitle());
            workToUpdate.setDetails(work.getDetails());
            workToUpdate.setSubjects(work.getSubjects());
            return Mapper.toDto(workRepository.save(workToUpdate));
        }
        throw new RuntimeException("Work not found with id " + id);
    }

    public void deleteWork(Long id){
        workRepository.deleteById(id);
    }

    public List<WorkDto> getWorksByTitle(String title){
        List<WorkDto> workDtos = new ArrayList<>();
        List<Work> works = workRepository.findByTitleContaining(title);
        for (Work work : works) {
            workDtos.add(Mapper.toDto(work));
        }
        return workDtos;
    }
}
