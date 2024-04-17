package com.maze.student.Score;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.maze.student.CourseEnroll.CourseEnroll;
import com.maze.student.StudentEnroll.StudentEnrolment;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Results {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @ManyToOne
    @JoinColumn(  name = "studentId" )
    @JsonIgnoreProperties(value = {"Results"})
    private StudentEnrolment studentEnrolment;

    @ManyToOne
    @JoinColumn(  name = "courseId" )
    @JsonIgnoreProperties(value = {"Results"})
    private CourseEnroll courseEnroll;
    private  float mid;
    private  float quiz;
    private  float final_result;
    private  float assignment;
    private  float total=mid+quiz+final_result+assignment;
}
