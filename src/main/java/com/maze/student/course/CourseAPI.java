package com.maze.student.course;

import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface CourseAPI {
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    CourseDTO updateCourse(@PathVariable long id, @RequestBody Course course);

    @GetMapping("/{id}")
    ResponseEntity<CourseDTO> findCourseById(@PathVariable Long id);

    @DeleteMapping("/{id}")
    ResponseEntity<CourseDTO> deleteCourseById(@PathVariable Long id);

    @GetMapping
    ResponseEntity<CollectionModel<CourseDTO>> findAll(
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer size);
    @PostMapping
    CourseDTO addCourse(@RequestBody Course course);

}
