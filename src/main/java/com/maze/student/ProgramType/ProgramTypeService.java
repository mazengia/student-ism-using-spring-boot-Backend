package com.maze.student.ProgramType;

import org.springframework.hateoas.CollectionModel;

public interface ProgramTypeService {
    CollectionModel<ProgramTypeDTO> findAll(int page, int size );

    ProgramTypeDTO addProgramType(ProgramType programType);

    ProgramTypeDTO findProgramTypeById(Long id);
}
