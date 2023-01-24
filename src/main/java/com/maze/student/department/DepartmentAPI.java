package com.maze.student.department;

import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface DepartmentAPI {
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    DepartmentDTO updateDepartment(@PathVariable long id, @RequestBody Department department);

    @GetMapping("/{id}")
    ResponseEntity<DepartmentDTO> findDepartmentById(@PathVariable Long id);

    @GetMapping
    ResponseEntity<CollectionModel<DepartmentDTO>> findAll(
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer size);
    @PostMapping
    DepartmentDTO addDepartment(@RequestBody Department department);

}
