package com.maze.student.Program;

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
public class ProgramServiceImpl implements ProgramService {

    ProgramRepository programRepository;
    ProgramAssembler programAssembler;
    PagedResourcesAssembler pagedResourcesAssembler;

    @Override
    public CollectionModel<ProgramDTO> findAll(int page, int size) {
        PageRequest pageRequest;
        pageRequest = PageRequest.of(page, size);
        Page<Programs> programTypes = programRepository.findAll(pageRequest);
        if (!CollectionUtils.isEmpty(programTypes.getContent()))
            return pagedResourcesAssembler.toModel(programTypes, programAssembler);

        return null;
    }

    @Override
    public ProgramDTO addProgramType(Programs programs) {
        return programAssembler.toModel(programRepository.save(programs));
    }

    @Override
    public ProgramDTO findProgramTypeById(Long id) {
        Programs programs = programRepository.findById(id).orElse(null);
        if (programs != null) {
            return programAssembler.toModel(programs);
        }
        return null;
    }

    @Override
    public ProgramDTO deleteProgramTypeById(Long id) throws ResourceNotFoundException {
        Programs programs = programRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(
                        "Program type with ID :" + id + " Not Found!")
        );
        programRepository.deleteById(programs.getId());
        return programAssembler.toModel(programs);
    }
}
