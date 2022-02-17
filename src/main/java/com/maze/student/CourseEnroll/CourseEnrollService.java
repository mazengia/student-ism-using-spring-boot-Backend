package com.maze.student.CourseEnroll;

import org.springframework.hateoas.CollectionModel;

public interface CourseEnrollService {
    CollectionModel<CourseEnrollDTO> findAll(int page, int size );

    CourseEnrollDTO enrollCourse(CoursEnroll coursEnroll);

    CourseEnrollDTO findCourseById(Long id);
}
