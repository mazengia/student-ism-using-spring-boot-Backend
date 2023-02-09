package com.maze.student.Score;

import com.maze.student.CourseEnroll.CourseEnroll;
import com.maze.student.StudentEnroll.StudentEnrolment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.RepresentationModel;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class ResultDTO extends RepresentationModel<ResultDTO> {
    private  Long id;
    private StudentEnrolment studentEnrolment;
    private CourseEnroll courseEnroll;
    private  float mid;
    private  float quiz;
    private  float final_result;
    private  float assignment;
    private  float total;
//    =mid+quiz+final_result+assignment
}
