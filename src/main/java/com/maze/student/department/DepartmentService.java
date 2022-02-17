package com.maze.student.department;

import org.springframework.hateoas.CollectionModel;

public interface DepartmentService {

    CollectionModel<DepartmentDTO> findAll(int page, int size );

    DepartmentDTO addDepartment(Department department);

    DepartmentDTO findDepartmentById(Long id);
}
