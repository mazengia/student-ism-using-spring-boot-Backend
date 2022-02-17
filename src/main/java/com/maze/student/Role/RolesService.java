package com.maze.student.Role;

import com.maze.student.exception.ResourceNotFoundException;
import org.springframework.hateoas.CollectionModel;

public interface RolesService {
    CollectionModel<RolesDTO> findAll(int page, int size );

    RolesDTO addRoles(Roles roles);

    RolesDTO findRolesById(Long id);
    RolesDTO deleteById(Long id) throws ResourceNotFoundException;
}
