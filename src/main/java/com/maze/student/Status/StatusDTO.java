package com.maze.student.Status;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.RepresentationModel;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class StatusDTO extends RepresentationModel<StatusDTO> {
    private final Long id;
    private String name;
    private String description;

}
