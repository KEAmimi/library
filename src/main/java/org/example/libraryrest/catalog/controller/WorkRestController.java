package org.example.libraryrest.catalog.controller;

import org.example.libraryrest.catalog.dtos.WorkDto;
import org.example.libraryrest.catalog.model.Work;
import org.example.libraryrest.catalog.service.WorkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/works")
public class WorkRestController {

    private final WorkService workService;
    public WorkRestController(WorkService workService) {
        this.workService = workService;
    }

    @GetMapping
    public ResponseEntity<List<WorkDto>> getWorks(@RequestParam(required = false) String title) {
        if (title != null && !title.isEmpty()) {
            return ResponseEntity.ok(workService.getWorksByTitle(title));
        }
        return ResponseEntity.ok(workService.getAllWorks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkDto> getWork(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(workService.getWorkById(id));
        }
        catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

//    @GetMapping
//    public ResponseEntity<List> getWorkByTitle(@RequestParam(required = false) String title) {
//        return ResponseEntity.ok(workService.getWorksByTitle(title));
//    }

    @PostMapping
    public ResponseEntity<WorkDto> createWork(@RequestBody WorkDto workDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(workService.createWork(workDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<WorkDto> updateWork(@PathVariable Long id, @RequestBody WorkDto workDto) {
        try{
            return ResponseEntity.ok(workService.updateWork(id, workDto));
        }
        catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWork(@PathVariable Long id) {
        try{
            workService.deleteWork(id);
            return ResponseEntity.noContent().build();
        }
        catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }


}
