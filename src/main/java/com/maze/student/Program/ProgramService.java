package com.maze.student.Program;

import com.maze.student._config.exception.ResourceNotFoundException;
import org.springframework.hateoas.CollectionModel;

public interface ProgramService {
    CollectionModel<ProgramDTO> findAll(int page, int size );

    ProgramDTO addProgramType(Programs programs);

    ProgramDTO findProgramTypeById(Long id);
    ProgramDTO deleteProgramTypeById(Long id) throws ResourceNotFoundException;

}
