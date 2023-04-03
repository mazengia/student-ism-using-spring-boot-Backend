package com.maze.student.CertificationType;

import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public class CertificationAssembler implements RepresentationModelAssembler<Certifications, CertificationDTO> {

    @Override
    public CertificationDTO toModel(Certifications certifications) {
        return new CertificationDTO(
                certifications.getId(),
                certifications.getName()
        );
    }
}
