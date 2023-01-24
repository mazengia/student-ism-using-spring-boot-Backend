package com.maze.student.Status;

import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public class StatusAssembler implements RepresentationModelAssembler<Status, StatusDTO> {

    @Override
    public StatusDTO toModel(Status status) {
        return new StatusDTO(
                status.getId(),
                status.getName(),
                status.getDescription()
        );
    }
}
