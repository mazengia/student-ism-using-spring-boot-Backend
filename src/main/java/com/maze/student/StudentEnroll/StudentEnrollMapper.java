package com.maze.student.StudentEnroll;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentEnrollMapper {

    StudentEnrolment toStudentEnrolment(EnrollDto enrollDto);
    EnrollDto toStudentDTO(StudentEnrolment studentEnrolment);
}
