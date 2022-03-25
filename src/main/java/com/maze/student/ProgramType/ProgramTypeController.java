package com.maze.student.ProgramType;

import com.maze.student.security.SecuredRestController;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/program-type")
public class ProgramTypeController   implements SecuredRestController {

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

    @DeleteMapping(value = "/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Long> deleteProgramType(@PathVariable Long id) {

        var isRemoved = programTypeService.deleteProgramTypeById(id);

        if (isRemoved == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
