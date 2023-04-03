package com.maze.student.CertificationType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.RepresentationModel;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class CertificationDTO extends RepresentationModel<CertificationDTO> {
    private final Long id;
    private final String name;

}
