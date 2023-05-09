package com.maze.student.StudentEnroll;

import com.maze.student.CerteficationYear.CertificationYear;
import com.maze.student.Sections.Sections;
import com.maze.student.Semisters.Semesters;
import com.maze.student._config.util.Auditable;
import com.maze.student.users.SystemUsers;
import lombok.Data;

@Data
public class EnrollDto extends Auditable {
    private SystemUsers student;
    private final Long id;
    private String cgpa ;
    private String pgpa ;
    private CertificationYear certificationYear;
    private Semesters semesters;
    private Sections sections;

}
