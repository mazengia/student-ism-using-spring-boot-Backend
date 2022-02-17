package com.bezkoder.student.StudentEnroll;

import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public class StudentAssembler implements RepresentationModelAssembler<StudentEnrolment, StudentDTO> {

    @Override
    public StudentDTO toModel(StudentEnrolment studentEnrolment) {
        return new StudentDTO(
                studentEnrolment.getId(),
                studentEnrolment.getBatch(),
                studentEnrolment.getSection(),
                studentEnrolment.getFirstSemester(),
                studentEnrolment.getSecondSemester(),
                studentEnrolment.getThirdSemester(),
                studentEnrolment.getCGPA(),
                studentEnrolment.getPGPA(),
                studentEnrolment.getThirdSemesterPoint(),
                studentEnrolment.getSecondSemesterPoint(),
                studentEnrolment.getThirdSemesterPoint()
        );
    }
}
