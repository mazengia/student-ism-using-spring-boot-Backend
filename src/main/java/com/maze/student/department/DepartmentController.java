package com.maze.student.department;

import com.maze.student.security.SecuredRestController;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/department")
public class DepartmentController implements SecuredRestController {

    DepartmentService departmentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ADMIN')")
    public DepartmentDTO addDepartment(@RequestBody Department department) {
        return departmentService.addDepartment(department);
    }

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> findAll(@RequestParam(required = false, defaultValue = "0") Integer page,
                                     @RequestParam(required = false, defaultValue = "10") Integer size) {
        CollectionModel<DepartmentDTO> departmentDTOS = departmentService.findAll(page, size);
        if (departmentDTOS != null) {
            return ResponseEntity.ok(departmentDTOS);
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> findDepartmentById(@PathVariable Long id) {
        DepartmentDTO departmentDTO = departmentService.findDepartmentById(id);
        if (departmentDTO != null) return ResponseEntity.ok(departmentDTO);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deleteDepartmentById(@PathVariable Long id) {
        DepartmentDTO departmentDTO = departmentService.deleteDepartmentById(id);
        if (departmentDTO != null) return ResponseEntity.ok(departmentDTO);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> updateDepartment(@PathVariable Long id, @RequestBody Department department) {
        DepartmentDTO departmentDTO = departmentService.updateDepartment(id, department);
        if (departmentDTO != null) return ResponseEntity.ok(departmentDTO);
        return ResponseEntity.noContent().build();


    }
}