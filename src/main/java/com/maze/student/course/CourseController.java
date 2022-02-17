package com.maze.student.course;

import org.springframework.hateoas.CollectionModel;
import org.springframework.http.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/course")
public class CourseController {

    CourseService courseService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public CourseDTO addCourse(@RequestBody Course course) {
         return courseService.addCourse(course);
    }

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> findAll(
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer size) {
        CollectionModel<CourseDTO> courseDTOS = courseService.findAll(page, size);
        if (courseDTOS != null) {
            return ResponseEntity.ok(courseDTOS);
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> findCourseId(@PathVariable Long id) {
        CourseDTO courseDTO = courseService.findCourseById(id);
        if (courseDTO != null) return ResponseEntity.ok(courseDTO);
        return ResponseEntity.noContent().build();
    }
}
