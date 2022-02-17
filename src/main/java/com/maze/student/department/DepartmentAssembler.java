package com.maze.student.department;

import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public class DepartmentAssembler implements RepresentationModelAssembler<Department, DepartmentDTO> {

    @Override
    public DepartmentDTO toModel(Department department) {
        return new DepartmentDTO(
                department.getId(),
                department.getCode(),
                department.getName()
        );
    }
}
