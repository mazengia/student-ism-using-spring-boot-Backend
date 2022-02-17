package com.maze.student.CourseEnroll;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/course-enrol")
public class CourseEnrollController {

    CourseEnrollService courseEnrollService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> enrollCourse(@RequestBody CoursEnroll coursEnroll) {
        CourseEnrollDTO courseEnrollDTO = courseEnrollService.enrollCourse(coursEnroll);
        return ResponseEntity.created(
                        courseEnrollDTO.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(courseEnrollDTO);
    }

    public CourseEnrollController(CourseEnrollService courseEnrollService) {
        this.courseEnrollService = courseEnrollService;
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> findAll(
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer size) {
        CollectionModel<CourseEnrollDTO> courseEnrollDTOS = courseEnrollService.findAll(page, size);
        if (courseEnrollDTOS != null) {
            return ResponseEntity.ok(courseEnrollDTOS);
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> findCourseId(@PathVariable Long id) {
        CourseEnrollDTO courseEnrollDTO = courseEnrollService.findCourseById(id);
        if (courseEnrollDTO != null) return ResponseEntity.ok(courseEnrollDTO);
        return ResponseEntity.noContent().build();
    }
}
