package com.maze.student.StudentEnroll;

import com.maze.student.CerteficationYear.CertificationYear;
import com.maze.student.Sections.Sections;
import com.maze.student.Semisters.Semesters;
import com.maze.student.users.SystemUsers;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.RepresentationModel;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class StudentDTO extends RepresentationModel<StudentDTO> {
    private SystemUsers student;
    private final Long id;
    private CertificationYear certificationYear;
    private Semesters semesters;
    private Sections sections;

}
