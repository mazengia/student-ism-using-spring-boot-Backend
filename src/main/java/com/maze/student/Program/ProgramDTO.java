package com.maze.student.Program;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.RepresentationModel;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class ProgramDTO extends RepresentationModel<ProgramDTO> {
    private final Long id;
    private final String name;

}
