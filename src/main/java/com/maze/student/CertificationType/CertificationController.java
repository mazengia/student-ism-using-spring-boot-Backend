package com.maze.student.CertificationType;

import com.maze.student._config.security.SecuredRestController;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/programs")
public class CertificationController implements SecuredRestController {

    CertificationService certificationService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public CertificationDTO addProgram(@RequestBody Certifications certifications)  {
        return certificationService.addProgram(certifications);
    }

    public CertificationController(CertificationService certificationService) {
        this.certificationService = certificationService;
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> findAll(
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer size) {
        CollectionModel<CertificationDTO> programDTOS = certificationService.findAll(page, size);
        if (programDTOS != null) {
            return ResponseEntity.ok(programDTOS);
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> findProgramById(@PathVariable Long id) {
        CertificationDTO certificationDTO = certificationService.findProgramById(id);
        if (certificationDTO != null) return ResponseEntity.ok(certificationDTO);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Long> deleteProgram(@PathVariable Long id) {

        var isRemoved = certificationService.deleteProgramById(id);

        if (isRemoved == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
