package com.maze.student.department;


import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.CollectionModel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;


import java.util.Optional;

import static com.maze.student.security.jwt.Util.getNullPropertyNames;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    DepartmentRepository departmentRepository;
    DepartmentAssembler departmentAssembler;
    PagedResourcesAssembler pagedResourcesAssembler;

    @Override
    public CollectionModel<DepartmentDTO> findAll(int page, int size ) {
        PageRequest pageRequest;
        pageRequest = PageRequest.of(page, size );
        Page<Department> departments = departmentRepository.findAll(pageRequest);
        if(! CollectionUtils.isEmpty(departments.getContent()))
            return pagedResourcesAssembler.toModel(departments, departmentAssembler);
        return null;
    }

    @Override
    public DepartmentDTO findDepartmentById(Long id) {
        Department department = departmentRepository.findById(id).orElse(null);
        if(department != null) {
            return departmentAssembler.toModel(department);
        }
        return null;
    }

    @Override
    public DepartmentDTO deleteDepartmentById(Long id) {
        departmentRepository.deleteById(id);
        return null ;
    }




    @Override
    public DepartmentDTO updateDepartment(Long departmentId, Department department) {

        Optional<Department> departmentData = departmentRepository.findById(departmentId);
        Department _data = departmentData.get();
        String code = department.getCode();
        String name = department.getName();
        _data.setCode(code);
        _data.setName(name);
         departmentRepository.save(_data);
        return null;
    }

    @Transactional
    public DepartmentDTO addDepartment(Department department) {
        return departmentAssembler.toModel(departmentRepository.save(department));
    }
}
