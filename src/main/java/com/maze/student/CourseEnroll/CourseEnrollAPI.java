package com.maze.student.CourseEnroll;

import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface CourseEnrollAPI {
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    CourseEnrollDTO updateCourseEnroll(@PathVariable long id, @RequestBody CoursEnroll coursEnroll);

    @GetMapping("/{id}")
    ResponseEntity<CourseEnrollDTO> findCourseEnrollById(@PathVariable Long id);

    @GetMapping
    ResponseEntity<CollectionModel<CourseEnrollDTO>> findAllEnroll(
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer size);
    @PostMapping
    CourseEnrollDTO addCourseEnroll(@RequestBody CoursEnroll coursEnroll);

}
