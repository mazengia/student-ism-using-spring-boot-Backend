package com.maze.student.CourseEnroll;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.maze.student.Batch.Batches;
import com.maze.student.Dpt.Dpt;
import com.maze.student.Semisters.Semesters;
import com.maze.student.course.Course;
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
@Table(uniqueConstraints={ @UniqueConstraint(columnNames = {"batchesId","semestersId","dptId","courseId" })})

public class CourseEnroll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(  name = "batchesId" )
    @JsonIgnoreProperties(value = {"CourseEnroll"})
    private Batches batches;

    @ManyToOne
    @JoinColumn(  name = "semestersId" )
    @JsonIgnoreProperties(value = {"CourseEnroll"})
    private Semesters semesters;


    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "dptId", referencedColumnName = "id")
    @JsonIgnoreProperties(value = {"CourseEnroll"})
    private Dpt dpt;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "courseId", referencedColumnName = "id")
    @JsonIgnoreProperties(value = {"CourseEnroll"})
    private Course course;

}
