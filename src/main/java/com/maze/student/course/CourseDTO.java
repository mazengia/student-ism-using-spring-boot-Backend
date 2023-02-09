package com.maze.student.course;

import com.maze.student.Department.Department;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.RepresentationModel;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class CourseDTO extends RepresentationModel<CourseDTO> {
    private final Long id;
    private final String code;
    private final String name;
    private final int creditHour;
    private final int ects;
    private final Department department;

}
