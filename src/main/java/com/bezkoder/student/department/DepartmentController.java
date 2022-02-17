package com.bezkoder.student.department;

import org.springframework.hateoas.CollectionModel;
import org.springframework.http.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/department")
public class DepartmentController {

    DepartmentService departmentService;

    @PostMapping
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

    @GetMapping("/{code}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> findDepartmentByCode(@PathVariable Long code) {
        DepartmentDTO departmentDTO = departmentService.findDepartmentById(code);
        if (departmentDTO != null) return ResponseEntity.ok(departmentDTO);
        return ResponseEntity.noContent().build();
    }
}