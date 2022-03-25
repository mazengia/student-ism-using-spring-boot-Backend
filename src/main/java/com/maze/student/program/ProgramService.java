package com.maze.student.program;

import com.maze.student.exception.ResourceNotFoundException;
import org.springframework.hateoas.CollectionModel;

public interface ProgramService {
    CollectionModel<ProgramDTO> findAll(int page, int size );

    ProgramDTO addProgram(Programs programs);

    ProgramDTO findProgramById(Long id);

    ProgramDTO deleteProgramById(Long id) throws ResourceNotFoundException;
}
