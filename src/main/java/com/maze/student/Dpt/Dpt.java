package com.maze.student.Dpt;

import com.maze.student.CourseEnroll.CourseEnroll;
import com.maze.student.Department.Department;
import com.maze.student.ProgramType.ProgramType;
import com.maze.student.program.Programs;
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
    private ProgramType programType;

    @ManyToOne
    @JoinColumn(  name = "programsId" )
    private Programs programs;


    @OneToOne(mappedBy = "dpt")
    private CourseEnroll courseEnroll;
}
