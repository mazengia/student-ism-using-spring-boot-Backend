package com.maze.student.Department;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.RepresentationModel;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class DepartmentDTO extends RepresentationModel<DepartmentDTO> {
    private long id;
    private  String code;
    private  String name;

}
