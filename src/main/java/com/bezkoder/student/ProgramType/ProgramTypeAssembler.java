package com.bezkoder.student.ProgramType;

import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public class ProgramTypeAssembler implements RepresentationModelAssembler<ProgramType, ProgramTypeDTO> {

    @Override
    public ProgramTypeDTO toModel(ProgramType programType) {
        return new ProgramTypeDTO(
                programType.getId(),
                programType.getName()
        );
    }
}
