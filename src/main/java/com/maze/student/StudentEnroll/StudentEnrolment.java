package com.maze.student.StudentEnroll;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.maze.student.CerteficationYear.CertificationYear;
import com.maze.student.Sections.Sections;
import com.maze.student.Semisters.Semesters;
import com.maze.student.users.SystemUsers;
import lombok.*;
import javax.persistence.*;

@Data
@Entity
@Table(uniqueConstraints={ @UniqueConstraint(columnNames = {"batchesId","semestersId","sectionsId","studentId" })})

public class StudentEnrolment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(  name = "batchesId" )
    @JsonIgnoreProperties(value = {"StudentEnrolment"})
    private CertificationYear certificationYear;
    private String cgpa ;
    private String pgpa ;
    @ManyToOne
    @JoinColumn(  name = "semestersId" )
    @JsonIgnoreProperties(value = {"StudentEnrolment"})
    private Semesters semesters;

    @ManyToOne
    @JoinColumn(  name = "sectionsId" )
    @JsonIgnoreProperties(value = {"StudentEnrolment"})
    private Sections sections;
    @ManyToOne
    @JoinColumn(  name = "studentId" )
    @JsonIgnoreProperties(value = {"StudentEnrolment"})
    private SystemUsers student;
}
