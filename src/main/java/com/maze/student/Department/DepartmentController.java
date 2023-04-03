package com.maze.student.Department;

import com.maze.student._config.security.SecuredRestController;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/department")
public class DepartmentController implements SecuredRestController,DepartmentAPI {
    DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }


    @Override
    public DepartmentDTO updateDepartment(long id, Department department) {
        return departmentService.updateDepartment(id, department);
    }

    @Override
    public ResponseEntity<DepartmentDTO> findDepartmentById(Long id) {
        DepartmentDTO statusDTO = departmentService.findDepartmentById(id);
        if (statusDTO != null) return ResponseEntity.ok(statusDTO);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<CollectionModel<DepartmentDTO>> findAll(Integer page, Integer size) {
        {
            CollectionModel<DepartmentDTO> statusDTOS = departmentService.findAll(page, size);
            if (statusDTOS != null)
                return ResponseEntity.ok(statusDTOS);
            return ResponseEntity.noContent().build();
        }
    }


    @Override
    public DepartmentDTO addDepartment(Department department) {
        return departmentService.addDepartment(department);
    }
}
