package com.maze.student.ProgramType;

import com.maze.student.exception.ResourceNotFoundException;
import com.maze.student.program.ProgramDTO;
import org.springframework.hateoas.CollectionModel;

public interface ProgramTypeService {
    CollectionModel<ProgramTypeDTO> findAll(int page, int size );

    ProgramTypeDTO addProgramType(ProgramType programType);

    ProgramTypeDTO findProgramTypeById(Long id);
    ProgramTypeDTO deleteProgramTypeById(Long id) throws ResourceNotFoundException;

}
