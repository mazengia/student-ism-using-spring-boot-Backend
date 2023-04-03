package com.maze.student.Dpt;

import com.maze.student.CourseEnroll.CourseEnroll;
import com.maze.student.Department.Department;
import com.maze.student.Program.Programs;
import com.maze.student.CertificationType.Certifications;
import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(uniqueConstraints={ @UniqueConstraint(columnNames = {"departmentId", "typesId","programsId"})})

public class Dpt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @ManyToOne
    @JoinColumn(  name = "departmentId" )
    private Department department;

    @ManyToOne
    @JoinColumn(  name = "typesId" )
    private Programs programs;

    @ManyToOne
    @JoinColumn(  name = "programsId" )
    private Certifications certifications;


    @OneToOne(mappedBy = "dpt")
    private CourseEnroll courseEnroll;
}
