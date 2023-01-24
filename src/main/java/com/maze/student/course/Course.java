package com.maze.student.course;

import com.maze.student.CourseEnroll.CoursEnroll;
import com.maze.student.department.Department;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@Getter
@Setter
@RequiredArgsConstructor
@Entity
@EqualsAndHashCode(exclude = {"department"})
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @Column(unique = true)
    private  String name;
    @Column(unique = true)
    private  String code;
    private  int creditHour;
    private int ects;

    @ManyToOne
    @JoinColumn(  name = "departmentId" )
    private Department department;

    @OneToOne(mappedBy = "course")
    private CoursEnroll courseEnroll;
}
