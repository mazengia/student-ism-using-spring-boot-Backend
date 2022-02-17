package com.bezkoder.student.StudentEnroll;


 import com.bezkoder.student.users.models.Users;
 import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(uniqueConstraints={ @UniqueConstraint(columnNames = {"batch","section","firstSemester","secondSemester","thirdSemester", "studentId"})})

public class StudentEnrolment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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

    @ManyToOne
    @JoinColumn(  name = "studentId" )
    private Users systemUser;
}
