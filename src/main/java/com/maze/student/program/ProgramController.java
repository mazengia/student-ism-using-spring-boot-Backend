package com.maze.student.program;

import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/programs")
public class ProgramController {

    ProgramService programService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ProgramDTO addProgram(@RequestBody Programs programs)  {
        return programService.addProgram(programs);
    }

    public ProgramController(ProgramService programService) {
        this.programService = programService;
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> findAll(
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer size) {
        CollectionModel<ProgramDTO> programDTOS = programService.findAll(page, size);
        if (programDTOS != null) {
            return ResponseEntity.ok(programDTOS);
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> findProgramById(@PathVariable Long id) {
        ProgramDTO programDTO = programService.findProgramById(id);
        if (programDTO != null) return ResponseEntity.ok(programDTO);
        return ResponseEntity.noContent().build();
    }
}
