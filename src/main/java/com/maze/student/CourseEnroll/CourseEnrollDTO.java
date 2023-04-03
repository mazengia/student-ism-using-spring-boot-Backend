package com.maze.student.CourseEnroll;

import com.maze.student.CerteficationYear.CertificationYear;
import com.maze.student.Dpt.Dpt;
import com.maze.student.Semisters.Semesters;
import com.maze.student.course.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.RepresentationModel;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class CourseEnrollDTO extends RepresentationModel<CourseEnrollDTO> {
    private final Long id;
    private CertificationYear certificationYear;
    private Semesters semesters;
    private final Course course;
    private final Dpt dpt;

}
