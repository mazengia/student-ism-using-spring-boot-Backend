package com.maze.student.ProgramType;

import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/program-type")
public class ProgramTypeController {

    ProgramTypeService programTypeService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ProgramTypeDTO addProgramType(@RequestBody ProgramType programType) {
        return programTypeService.addProgramType(programType);
    }

    public ProgramTypeController(ProgramTypeService programTypeService) {
        this.programTypeService = programTypeService;
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> findAll(
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer size) {
        CollectionModel<ProgramTypeDTO> programTypeDTOS = programTypeService.findAll(page, size);
        if (programTypeDTOS != null) {
            return ResponseEntity.ok(programTypeDTOS);
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> findProgramById(@PathVariable Long id) {
        ProgramTypeDTO programTypeDTO = programTypeService.findProgramTypeById(id);
        if (programTypeDTO != null) return ResponseEntity.ok(programTypeDTO);
        return ResponseEntity.noContent().build();
    }
}
