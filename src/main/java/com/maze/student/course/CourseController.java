package com.maze.student.course;

import com.maze.student._config.security.SecuredRestController;
import com.maze.student._config.security.jwt.JwtUtils;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/course")
public class CourseController   implements SecuredRestController , CourseAPI {

    CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }


    @Override
    public CourseDTO updateCourse(long id, Course course) {
        return courseService.updateCourse(id, course);
    }

    @Override
    public ResponseEntity<CourseDTO> findCourseById(Long id) {
        CourseDTO statusDTO = courseService.findCourseById(id);
        if (statusDTO != null) return ResponseEntity.ok(statusDTO);
        return ResponseEntity.noContent().build();
    }


    @Override
    public ResponseEntity<CourseDTO> deleteCourseById(Long id) {
        CourseDTO statusDTO = courseService.deleteCourseById(id);
        if (statusDTO != null) return ResponseEntity.ok(statusDTO);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<CollectionModel<CourseDTO>> findAll(Integer page, Integer size, Authentication authentication) {
        {
            CollectionModel<CourseDTO> statusDTOS = courseService.findAll(page, size,authentication);
            if (statusDTOS != null)
                return ResponseEntity.ok(statusDTOS);
            return ResponseEntity.noContent().build();
        }
    }


    @Override
    public CourseDTO addCourse(Course course) {
        return courseService.addCourse(course);
    }
}
