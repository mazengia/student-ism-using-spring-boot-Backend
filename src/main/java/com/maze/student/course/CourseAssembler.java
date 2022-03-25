package com.maze.student.course;

import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public class CourseAssembler implements RepresentationModelAssembler<Course, CourseDTO> {

    @Override
    public CourseDTO toModel(Course course) {
        return new CourseDTO(
                course.getId(),
                course.getCode(),
                course.getName(),
                course.getCreditHour(),
                course.getEcts(),
                course.getDepartment()
        );
    }
}
