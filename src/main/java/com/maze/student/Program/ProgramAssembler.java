package com.maze.student.Program;

import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public class ProgramAssembler implements RepresentationModelAssembler<Programs, ProgramDTO> {

    @Override
    public ProgramDTO toModel(Programs programs) {
        return new ProgramDTO(
                programs.getId(),
                programs.getName()
        );
    }
}
