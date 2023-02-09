package com.maze.student.Department;

import org.springframework.hateoas.CollectionModel;


public interface DepartmentService {

    CollectionModel<DepartmentDTO> findAll(int page, int size );

    DepartmentDTO updateDepartment(Long departmentId, Department department);

    DepartmentDTO addDepartment(Department department);

    DepartmentDTO findDepartmentById(Long departmentId);
    DepartmentDTO deleteDepartmentById(Long departmentId);
}
