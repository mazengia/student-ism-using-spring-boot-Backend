package com.bezkoder.student.CourseEnroll;

import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public class CourseEnrollAssembler implements RepresentationModelAssembler<CoursEnroll, CourseEnrollDTO> {

    @Override
    public CourseEnrollDTO toModel(CoursEnroll coursEnroll) {
        return new CourseEnrollDTO(
                coursEnroll.getId(),
                coursEnroll.getBatch(),
                coursEnroll.getSemester(),
                coursEnroll.getCourse(),
                coursEnroll.getDpt()
        );
    }
}
