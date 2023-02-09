package com.maze.student.CourseEnroll;

import org.springframework.hateoas.CollectionModel;

public interface CourseEnrollService {
    CollectionModel<CourseEnrollDTO> findAll(int page, int size );

    CourseEnrollDTO enrollCourse(CourseEnroll courseEnroll);

    CourseEnrollDTO findCourseById(Long id);
    CourseEnrollDTO updateCourseEnroll(Long id, CourseEnroll courseEnroll);
}
