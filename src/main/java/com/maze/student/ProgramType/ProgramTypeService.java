package com.maze.student.ProgramType;

import com.maze.student._config.exception.ResourceNotFoundException;
import org.springframework.hateoas.CollectionModel;

public interface ProgramTypeService {
    CollectionModel<ProgramTypeDTO> findAll(int page, int size );

    ProgramTypeDTO addProgramType(ProgramType programType);

    ProgramTypeDTO findProgramTypeById(Long id);
    ProgramTypeDTO deleteProgramTypeById(Long id) throws ResourceNotFoundException;

}
