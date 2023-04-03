package com.maze.student.StudentEnroll;

import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public class StudentAssembler implements RepresentationModelAssembler<StudentEnrolment, StudentDTO> {

    @Override
    public StudentDTO toModel(StudentEnrolment studentEnrolment) {
        return new StudentDTO(
                        studentEnrolment.getStudent(),
                        studentEnrolment.getId(),
                        studentEnrolment.getCertificationYear(),
                        studentEnrolment.getSemesters(),
                        studentEnrolment.getSections()
                );
    }
}
