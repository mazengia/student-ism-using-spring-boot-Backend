package com.maze.student.Dpt;

import com.maze.student._config.exception.ResourceNotFoundException;
import com.maze.student._config.security.SecuredRestController;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/dpt")
public class DptController   implements SecuredRestController {

    DptService dptService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public DptDTO addDpt(@RequestBody Dpt dpt) {
        return dptService.addDpt(dpt);
    }

    public DptController(DptService dptService) {
        this.dptService = dptService;
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> findAll(
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer size) {
        CollectionModel<DptDTO> dptDTOS = dptService.findAll(page, size);
        if (dptDTOS != null) {
            return ResponseEntity.ok(dptDTOS);
        }
      else {
          throw  new ResourceNotFoundException("Can't get all dpt");
        }
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> findDptId(@PathVariable Long id) {
        DptDTO dptDTO = dptService.findDptById(id);
        if (dptDTO != null) {
            return ResponseEntity.ok(dptDTO);
        }
        else {
            throw  new ResourceNotFoundException("Can't get dpt whose id is " + id);
        }
    }
}
