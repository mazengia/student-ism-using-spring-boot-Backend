package com.maze.student.Dpt;

import com.maze.student.ProgramType.ProgramType;
import com.maze.student.department.Department;
import com.maze.student.program.Programs;
import com.maze.student.CourseEnroll.CoursEnroll;
import lombok.*;

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
    private CoursEnroll courseEnroll;
}
