package com.maze.student.CourseEnroll;

import com.maze.student._config.security.SecuredRestController;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/course-enrol")
public class CourseEnrollController   implements SecuredRestController,CourseEnrollAPI {

    CourseEnrollService courseEnrollService;
//    @PreAuthorize("hasRole('ADMIN')")

    public CourseEnrollController(CourseEnrollService courseEnrollService) {
        this.courseEnrollService = courseEnrollService;
    }

    @Override
    public CourseEnrollDTO updateCourseEnroll(long id, CourseEnroll courseEnroll) {
        return courseEnrollService.updateCourseEnroll(id, courseEnroll);
    }

    @Override
    public ResponseEntity<CourseEnrollDTO> findCourseEnrollById(Long id) {
        CourseEnrollDTO statusDTO = courseEnrollService.findCourseById(id);
        if (statusDTO != null) return ResponseEntity.ok(statusDTO);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<CollectionModel<CourseEnrollDTO>> findAllEnroll(Integer page, Integer size) {
        CollectionModel<CourseEnrollDTO> statusDTOS = courseEnrollService.findAll(page, size);
        if (statusDTOS != null)
            return ResponseEntity.ok(statusDTOS);
        return ResponseEntity.noContent().build();
    }
    @Override
    public CourseEnrollDTO addCourseEnroll(CourseEnroll courseEnroll) {
        return courseEnrollService.enrollCourse(courseEnroll);
    }
}
