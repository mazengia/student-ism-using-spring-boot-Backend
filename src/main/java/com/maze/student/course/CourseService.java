package com.maze.student.course;

import org.springframework.hateoas.CollectionModel;

public interface CourseService {
    CollectionModel<CourseDTO> findAll(int page, int size );

    CourseDTO addCourse(Course course);

    CourseDTO findCourseById(Long id);
    CourseDTO updateCourse(Long id, Course course);

    CourseDTO deleteCourseById(Long id);
}
