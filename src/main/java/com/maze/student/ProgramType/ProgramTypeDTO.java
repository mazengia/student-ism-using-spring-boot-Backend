package com.maze.student.ProgramType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.RepresentationModel;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class ProgramTypeDTO extends RepresentationModel<ProgramTypeDTO> {
    private final Long id;
    private final String name;

}
