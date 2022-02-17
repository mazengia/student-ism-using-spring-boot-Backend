package com.maze.student.Dpt;

import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public class DptAssembler implements RepresentationModelAssembler<Dpt, DptDTO> {

    @Override
    public DptDTO toModel(Dpt dpt) {
        return new DptDTO(
                dpt.getId(),
                dpt.getDepartment(),
                dpt.getProgramType(),
                dpt.getPrograms()
        );
    }
}
