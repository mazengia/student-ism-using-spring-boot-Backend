package com.maze.student.CourseEnroll;

import com.maze.student.Dpt.Dpt;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.RepresentationModel;
import com.maze.student.course.Course;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class CourseEnrollDTO extends RepresentationModel<CourseEnrollDTO> {
    private final Long id;
    private final int batch;
    private final String semester;
    private final Course course;
    private final Dpt dpt;

}
