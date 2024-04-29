package com.maze.student.CertificationType;

import com.maze.student.exception.ResourceNotFoundException;
import org.springframework.hateoas.CollectionModel;

public interface CertificationService {
    CollectionModel<CertificationDTO> findAll(int page, int size );

    CertificationDTO addProgram(Certifications certifications);

    CertificationDTO findProgramById(Long id);

    CertificationDTO deleteProgramById(Long id) throws ResourceNotFoundException;
}
