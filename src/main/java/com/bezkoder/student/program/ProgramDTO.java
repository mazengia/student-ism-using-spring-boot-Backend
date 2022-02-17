package com.bezkoder.student.program;

import lombok.*;
import org.springframework.hateoas.RepresentationModel;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class ProgramDTO extends RepresentationModel<ProgramDTO> {
    private final Long id;
    private final String name;

}
