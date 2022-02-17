package com.bezkoder.student.course;

import org.springframework.hateoas.CollectionModel;

public interface CourseService {
    CollectionModel<CourseDTO> findAll(int page, int size );

    CourseDTO addCourse(Course course);

    CourseDTO findCourseById(Long id);
}
