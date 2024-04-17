package com.maze.student.course;

import com.maze.student.CourseEnroll.CourseEnroll;
import com.maze.student.Department.Department;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
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
    private CourseEnroll courseEnroll;
}
