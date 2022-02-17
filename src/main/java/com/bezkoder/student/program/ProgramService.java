package com.bezkoder.student.program;

import org.springframework.hateoas.CollectionModel;

public interface ProgramService {
    CollectionModel<ProgramDTO> findAll(int page, int size );

    ProgramDTO addProgram(Programs programs);

    ProgramDTO findProgramById(Long id);
}
