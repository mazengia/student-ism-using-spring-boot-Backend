package com.bezkoder.student.course;

import com.bezkoder.student.department.Department;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class CourseDTO extends RepresentationModel<CourseDTO> {
    private final Long id;
    private final String name;
    private final String code;
    private final int creditHour;
    private final int ects;
    private final Department department;

}
