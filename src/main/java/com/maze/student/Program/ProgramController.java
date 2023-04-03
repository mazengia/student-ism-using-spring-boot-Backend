package com.maze.student.Program;

import com.maze.student._config.security.SecuredRestController;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/program-type")
public class ProgramController implements SecuredRestController {

    ProgramService programService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ProgramDTO addProgramType(@RequestBody Programs programs) {
        return programService.addProgramType(programs);
    }

    public ProgramController(ProgramService programService) {
        this.programService = programService;
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> findAll(
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer size) {
        CollectionModel<ProgramDTO> programTypeDTOS = programService.findAll(page, size);
        if (programTypeDTOS != null) {
            return ResponseEntity.ok(programTypeDTOS);
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> findProgramById(@PathVariable Long id) {
        ProgramDTO programDTO = programService.findProgramTypeById(id);
        if (programDTO != null) return ResponseEntity.ok(programDTO);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Long> deleteProgramType(@PathVariable Long id) {

        var isRemoved = programService.deleteProgramTypeById(id);

        if (isRemoved == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
