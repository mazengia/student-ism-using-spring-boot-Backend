package com.bezkoder.student.Dpt;

import com.bezkoder.student.ProgramType.ProgramType;
import com.bezkoder.student.department.Department;
import com.bezkoder.student.program.Programs;
import com.bezkoder.student.CourseEnroll.CoursEnroll;
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
