package com.maze.student.StudentEnroll;

import com.maze.student.users.models.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.RepresentationModel;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class StudentDTO extends RepresentationModel<StudentDTO> {
    private Users student;
    private final Long id;
    int batch;
    String section;
    String firstSemester;
    String secondSemester;
    String thirdSemester;
    float firstSemesterPoint;
    float secondSemesterPoint;
    float thirdSemesterPoint;
    float PGPA;//Previous GPA
    float CGPA;//Current GPA

}
