package com.maze.student.CertificationType;

import com.maze.student._config.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.CollectionModel;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
@AllArgsConstructor
public class CertificationServiceImpl implements CertificationService {

    CertificationRepository certificationRepository;
    CertificationAssembler certificationAssembler;
    PagedResourcesAssembler pagedResourcesAssembler;

    @Override
    public CollectionModel<CertificationDTO> findAll(int page, int size) {
        PageRequest pageRequest;
        pageRequest = PageRequest.of(page, size);
        Page<Certifications> programs = certificationRepository.findAll(pageRequest);
        if (!CollectionUtils.isEmpty(programs.getContent()))
            return pagedResourcesAssembler.toModel(programs, certificationAssembler);

        return null;
    }

    @Override
    public CertificationDTO addProgram(Certifications certifications) {
        return certificationAssembler.toModel(certificationRepository.save(certifications));
    }

    @Override
    public CertificationDTO findProgramById(Long id) {
        Certifications certifications = certificationRepository.findById(id).orElse(null);
        if (certifications != null) {
            return certificationAssembler.toModel(certifications);
        }
        return null;
    }

    @Override
    public CertificationDTO deleteProgramById(Long id)  throws ResourceNotFoundException {
        Certifications certifications = certificationRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(
                        "Program with ID :" + id + " Not Found!")
        );
        certificationRepository.deleteById(certifications.getId());
        return certificationAssembler.toModel(certifications);
    }
}
