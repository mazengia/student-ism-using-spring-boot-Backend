package com.maze.student.StudentEnroll;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-15T14:19:52+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class StudentEnrollMapperImpl implements StudentEnrollMapper {

    @Override
    public StudentEnrolment toStudentEnrolment(EnrollDto enrollDto) {
        if ( enrollDto == null ) {
            return null;
        }

        StudentEnrolment studentEnrolment = new StudentEnrolment();

        studentEnrolment.setId( enrollDto.getId() );
        studentEnrolment.setCertificationYear( enrollDto.getCertificationYear() );
        studentEnrolment.setCgpa( enrollDto.getCgpa() );
        studentEnrolment.setPgpa( enrollDto.getPgpa() );
        studentEnrolment.setSemesters( enrollDto.getSemesters() );
        studentEnrolment.setSections( enrollDto.getSections() );
        studentEnrolment.setStudent( enrollDto.getStudent() );

        return studentEnrolment;
    }

    @Override
    public EnrollDto toStudentDTO(StudentEnrolment studentEnrolment) {
        if ( studentEnrolment == null ) {
            return null;
        }

        Long id = null;

        id = studentEnrolment.getId();

        EnrollDto enrollDto = new EnrollDto( id );

        enrollDto.setStudent( studentEnrolment.getStudent() );
        enrollDto.setCgpa( studentEnrolment.getCgpa() );
        enrollDto.setPgpa( studentEnrolment.getPgpa() );
        enrollDto.setCertificationYear( studentEnrolment.getCertificationYear() );
        enrollDto.setSemesters( studentEnrolment.getSemesters() );
        enrollDto.setSections( studentEnrolment.getSections() );

        return enrollDto;
    }
}
