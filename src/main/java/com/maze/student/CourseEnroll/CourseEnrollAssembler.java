package com.maze.student.CourseEnroll;

import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public class CourseEnrollAssembler implements RepresentationModelAssembler<CourseEnroll, CourseEnrollDTO> {

    @Override
    public CourseEnrollDTO toModel(CourseEnroll courseEnroll) {
        return new CourseEnrollDTO(
                courseEnroll.getId(),
                courseEnroll.getCertificationYear(),
                courseEnroll.getSemesters(),
                courseEnroll.getCourse(),
                courseEnroll.getDpt()
        );
    }
}
