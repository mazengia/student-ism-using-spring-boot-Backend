package com.maze.student.program;

import com.maze.student.security.SecuredRestController;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/programs")
public class ProgramController   implements SecuredRestController {

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

    @DeleteMapping(value = "/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Long> deleteProgram(@PathVariable Long id) {

        var isRemoved = programService.deleteProgramById(id);

        if (isRemoved == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
